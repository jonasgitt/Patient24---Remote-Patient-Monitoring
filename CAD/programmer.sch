EESchema Schematic File Version 4
LIBS:HealthMonitor-cache
EELAYER 29 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 5 7
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L Interface_USB:CP2102N-A01-GQFN24 U12
U 1 1 5CE73842
P 4950 3500
F 0 "U12" H 4950 4578 50  0000 C CNN
F 1 "CP2102N-A01-GQFN24" H 4950 4487 50  0000 C CNN
F 2 "Package_DFN_QFN:QFN-24-1EP_4x4mm_P0.5mm_EP2.6x2.6mm" H 5400 2700 50  0001 L CNN
F 3 "http://www.silabs.com/support%20documents/technicaldocs/cp2102n-datasheet.pdf" H 5000 2450 50  0001 C CNN
	1    4950 3500
	1    0    0    -1  
$EndComp
NoConn ~ 4350 3200
NoConn ~ 4350 3300
NoConn ~ 5550 3000
NoConn ~ 5550 3100
NoConn ~ 5550 3400
NoConn ~ 5550 3500
NoConn ~ 5550 3600
NoConn ~ 5550 2900
NoConn ~ 5550 3800
NoConn ~ 5550 3900
NoConn ~ 5550 4000
NoConn ~ 5550 4100
Wire Wire Line
	4950 4400 4950 4450
Wire Wire Line
	4950 4450 5000 4450
Wire Wire Line
	5050 4450 5050 4400
$Comp
L power:GND #PWR065
U 1 1 5CE7527F
P 5000 4550
F 0 "#PWR065" H 5000 4300 50  0001 C CNN
F 1 "GND" H 5005 4377 50  0000 C CNN
F 2 "" H 5000 4550 50  0001 C CNN
F 3 "" H 5000 4550 50  0001 C CNN
	1    5000 4550
	1    0    0    -1  
$EndComp
Wire Wire Line
	5000 4550 5000 4450
Connection ~ 5000 4450
Wire Wire Line
	5000 4450 5050 4450
NoConn ~ 4850 2600
$Comp
L Device:C C22
U 1 1 5CE7663D
P 3900 3100
F 0 "C22" H 4015 3146 50  0000 L CNN
F 1 "0.1u" H 4015 3055 50  0000 L CNN
F 2 "Capacitor_SMD:C_0402_1005Metric" H 3938 2950 50  0001 C CNN
F 3 "~" H 3900 3100 50  0001 C CNN
	1    3900 3100
	1    0    0    -1  
$EndComp
Wire Wire Line
	3900 2950 3900 2900
Wire Wire Line
	3900 2900 4350 2900
$Comp
L power:GND #PWR063
U 1 1 5CE766D8
P 3900 3300
F 0 "#PWR063" H 3900 3050 50  0001 C CNN
F 1 "GND" H 4050 3250 50  0000 C CNN
F 2 "" H 3900 3300 50  0001 C CNN
F 3 "" H 3900 3300 50  0001 C CNN
	1    3900 3300
	1    0    0    -1  
$EndComp
Wire Wire Line
	3900 3300 3900 3250
$Comp
L power:+3V3 #PWR066
U 1 1 5CE76C6F
P 6550 2950
F 0 "#PWR066" H 6550 2800 50  0001 C CNN
F 1 "+3V3" H 6565 3123 50  0000 C CNN
F 2 "" H 6550 2950 50  0001 C CNN
F 3 "" H 6550 2950 50  0001 C CNN
	1    6550 2950
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR067
U 1 1 5CE76C7E
P 6550 3450
F 0 "#PWR067" H 6550 3200 50  0001 C CNN
F 1 "GND" H 6555 3277 50  0000 C CNN
F 2 "" H 6550 3450 50  0001 C CNN
F 3 "" H 6550 3450 50  0001 C CNN
	1    6550 3450
	1    0    0    -1  
$EndComp
$Comp
L Device:C C23
U 1 1 5CE76C8D
P 6550 3200
F 0 "C23" H 6665 3246 50  0000 L CNN
F 1 "1u" H 6665 3155 50  0000 L CNN
F 2 "Capacitor_SMD:C_0402_1005Metric" H 6588 3050 50  0001 C CNN
F 3 "~" H 6550 3200 50  0001 C CNN
	1    6550 3200
	1    0    0    -1  
$EndComp
Wire Wire Line
	6550 2950 6550 3000
Wire Wire Line
	6550 3350 6550 3400
$Comp
L power:GND #PWR062
U 1 1 5CE7739E
P 3850 4250
F 0 "#PWR062" H 3850 4000 50  0001 C CNN
F 1 "GND" H 3855 4077 50  0000 C CNN
F 2 "" H 3850 4250 50  0001 C CNN
F 3 "" H 3850 4250 50  0001 C CNN
	1    3850 4250
	1    0    0    -1  
$EndComp
$Comp
L Device:C C21
U 1 1 5CE773A4
P 3850 4000
F 0 "C21" H 3965 4046 50  0000 L CNN
F 1 "1u" H 3965 3955 50  0000 L CNN
F 2 "Capacitor_SMD:C_0402_1005Metric" H 3888 3850 50  0001 C CNN
F 3 "~" H 3850 4000 50  0001 C CNN
	1    3850 4000
	1    0    0    -1  
$EndComp
Wire Wire Line
	3850 4150 3850 4250
Wire Wire Line
	3850 3850 3850 3800
Wire Wire Line
	3850 3800 4350 3800
$Comp
L power:+3V3 #PWR064
U 1 1 5CE77B6B
P 4950 2300
F 0 "#PWR064" H 4950 2150 50  0001 C CNN
F 1 "+3V3" H 4965 2473 50  0000 C CNN
F 2 "" H 4950 2300 50  0001 C CNN
F 3 "" H 4950 2300 50  0001 C CNN
	1    4950 2300
	1    0    0    -1  
$EndComp
Wire Wire Line
	4950 2300 4950 2600
Wire Wire Line
	3850 3500 3850 3800
Wire Wire Line
	3850 3500 4350 3500
Connection ~ 3850 3800
Connection ~ 3850 3500
Text HLabel 3050 3500 0    50   Input ~ 0
VBUS
Text HLabel 4300 3900 0    50   Input ~ 0
D+
Text HLabel 4300 4000 0    50   Input ~ 0
D-
Wire Wire Line
	4300 3900 4350 3900
Wire Wire Line
	4300 4000 4350 4000
Text HLabel 6750 3000 2    50   Input ~ 0
VCC
Text HLabel 6750 3400 2    50   Input ~ 0
GND
Wire Wire Line
	6750 3400 6550 3400
Connection ~ 6550 3400
Wire Wire Line
	6550 3400 6550 3450
Wire Wire Line
	6750 3000 6550 3000
Connection ~ 6550 3000
Wire Wire Line
	6550 3000 6550 3050
Text HLabel 5700 3200 2    50   Input ~ 0
RX
Text HLabel 5700 3300 2    50   Input ~ 0
TX
Wire Wire Line
	5700 3300 5550 3300
Wire Wire Line
	5550 3200 5700 3200
Wire Wire Line
	3050 3500 3850 3500
$EndSCHEMATC
