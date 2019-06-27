/*
 * Copyright (c) 2015, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.frieling.android.Patient24App.bpm;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.TextView;

import java.util.Calendar;
import java.util.UUID;

import no.nordicsemi.android.ble.common.profile.bp.BloodPressureMeasurementCallback;
import no.nordicsemi.android.ble.common.profile.bp.IntermediateCuffPressureCallback;
import com.frieling.android.Patient24App.R;
import com.frieling.android.Patient24App.profile.BleProfileActivity;
import com.frieling.android.Patient24App.profile.LoggableBleManager;

// TODO The BPMActivity should be rewritten to use the service approach, like other do.
public class BPMActivity extends BleProfileActivity implements BPMManagerCallbacks {
	@SuppressWarnings("unused")
	private static final String TAG = "BPMActivity";

	private TextView mSystolicView;
	private TextView mSystolicUnitView;
	private TextView mDiastolicView;
	private TextView mDiastolicUnitView;
	private TextView mMeanAPView;
	private TextView mMeanAPUnitView;
	private TextView mPulseView;
	private TextView mTimestampView;
	private TextView mBatteryLevelView;

	@Override
	protected void onCreateView(final Bundle savedInstanceState) {
		setContentView(R.layout.activity_feature_bpm);
		setGUI();
	}

	private void setGUI() {
		mSystolicView = findViewById(R.id.systolic);
		mSystolicUnitView = findViewById(R.id.systolic_unit);
		mDiastolicView = findViewById(R.id.diastolic);
		mDiastolicUnitView = findViewById(R.id.diastolic_unit);
		mMeanAPView = findViewById(R.id.mean_ap);
		mMeanAPUnitView = findViewById(R.id.mean_ap_unit);
		mPulseView = findViewById(R.id.pulse);
		mTimestampView = findViewById(R.id.timestamp);
		mBatteryLevelView = findViewById(R.id.battery);
	}

	@Override
	protected int getLoggerProfileTitle() {
		return R.string.bpm_feature_title;
	}

	@Override
	protected int getDefaultDeviceName() {
		return R.string.bpm_default_name;
	}

	@Override
	protected int getAboutTextId() {
		return R.string.bpm_about_text;
	}

	@Override
	protected UUID getFilterUUID() {
		return BPMManager.BP_SERVICE_UUID;
	}

	@Override
	protected LoggableBleManager<BPMManagerCallbacks> initializeManager() {
		final BPMManager manager = BPMManager.getBPMManager(getApplicationContext());
		manager.setGattCallbacks(this);
		return manager;
	}

	@Override
	protected void setDefaultUI() {
		mSystolicView.setText(R.string.not_available_value);
		mSystolicUnitView.setText(null);
		mDiastolicView.setText(R.string.not_available_value);
		mDiastolicUnitView.setText(null);
		mMeanAPView.setText(R.string.not_available_value);
		mMeanAPUnitView.setText(null);
		mPulseView.setText(R.string.not_available_value);
		mTimestampView.setText(R.string.not_available);
		mBatteryLevelView.setText(R.string.not_available);
	}

	@Override
	public void onServicesDiscovered(@NonNull final BluetoothDevice device, final boolean optionalServicesFound) {
		// this may notify user or show some views
	}

	@Override
	public void onDeviceReady(@NonNull final BluetoothDevice device) {
		// this may notify user
	}

	@Override
	public void onDeviceDisconnected(@NonNull final BluetoothDevice device) {
		super.onDeviceDisconnected(device);
		runOnUiThread(() -> mBatteryLevelView.setText(R.string.not_available));
	}

	@Override
	public void onBloodPressureMeasurementReceived(@NonNull final BluetoothDevice device,
												   final float systolic, final float diastolic, final float meanArterialPressure, final int unit,
												   @Nullable final Float pulseRate, @Nullable final Integer userID,
												   @Nullable final BPMStatus status, @Nullable final Calendar calendar) {
		runOnUiThread(() -> {
			mSystolicView.setText(String.valueOf(systolic));
			mDiastolicView.setText(String.valueOf(diastolic));
			mMeanAPView.setText(String.valueOf(meanArterialPressure));
			if (pulseRate != null)
				mPulseView.setText(String.valueOf(pulseRate));
			else
				mPulseView.setText(R.string.not_available_value);
			if (calendar != null)
				mTimestampView.setText(getString(R.string.bpm_timestamp, calendar));
			else
				mTimestampView.setText(R.string.not_available);

			mSystolicUnitView.setText(unit == BloodPressureMeasurementCallback.UNIT_mmHg ? R.string.bpm_unit_mmhg : R.string.bpm_unit_kpa);
			mDiastolicUnitView.setText(unit == BloodPressureMeasurementCallback.UNIT_mmHg ? R.string.bpm_unit_mmhg : R.string.bpm_unit_kpa);
			mMeanAPUnitView.setText(unit == BloodPressureMeasurementCallback.UNIT_mmHg ? R.string.bpm_unit_mmhg : R.string.bpm_unit_kpa);
		});
	}

	@Override
	public void onIntermediateCuffPressureReceived(@NonNull final BluetoothDevice device, final float cuffPressure, final int unit,
												   @Nullable final Float pulseRate, @Nullable final Integer userID,
												   @Nullable final BPMStatus status, @Nullable final Calendar calendar) {
		runOnUiThread(() -> {
			mSystolicView.setText(String.valueOf(cuffPressure));
			mDiastolicView.setText(R.string.not_available_value);
			mMeanAPView.setText(R.string.not_available_value);
			if (pulseRate != null)
				mPulseView.setText(String.valueOf(pulseRate));
			else
				mPulseView.setText(R.string.not_available_value);
			if (calendar != null)
				mTimestampView.setText(getString(R.string.bpm_timestamp, calendar));
			else
				mTimestampView.setText(R.string.not_available);

			mSystolicUnitView.setText(unit == IntermediateCuffPressureCallback.UNIT_mmHg ? R.string.bpm_unit_mmhg : R.string.bpm_unit_kpa);
			mDiastolicUnitView.setText(null);
			mMeanAPUnitView.setText(null);
		});
	}

	@Override
	public void onBatteryLevelChanged(@NonNull final BluetoothDevice device, final int batteryLevel) {
		runOnUiThread(() -> mBatteryLevelView.setText(getString(R.string.battery, batteryLevel)));
	}
}