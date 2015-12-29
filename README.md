# demo-jmh

to run benchmarks
```
gradlew clean jmh
```

#Benchmarks

##Collections
this benchmarks show difference between standard java List implementations

##ParseInt
this benchmarks show difference between different implementations of parsing int in Java

###parseStringToIntIntegerParseInt
using Integer.parseInt
supports negative values, throws exception if string is not valid integer

###parseStringToIntLuxoft
using code from email I got
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntUsingSwitch
using switch statement instead of calculating values from character codes
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntReflectionGetChars
get char array using reflection instead toCharArray to avoid coping array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftFori
using code from email I got, with change to charAt
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftFori2
using code from email I got, with change to charAt and local variable inside loop
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftChars
for loop on char array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftChars2
fori loop on char array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftChars3
fori loop on char array and local variable inside loop
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntStackOverflow
implementation found on StackOverflow
supports negative values, throws exception if string is not valid integer

###parseStringToIntUtf8Bytes
for loop on byte array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntUtf8Bytes2
fori loop on byte array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntUtf8Bytes3
fori loop on byte array and local variable inside loop
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntUtf16Bytes
for loop on byte array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntUtf16Bytes2
fori loop on byte array
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntUtf16Bytes3
fori loop on byte array and local variable inside loop
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntStringToUtf8Bytes
for loop on byte array, byte array create from string
supports only positive values, returns -1 if string is not valid integer

###parseStringToIntStringToUtf16Bytes
for loop on byte array, byte array create from string
supports only positive values, returns -1 if string is not valid integer


#example result
```
# Run complete. Total time: 00:02:19

Benchmark                                    (toParse)   Mode  Cnt          Score           Error  Units
Collections.addArrayList                           N/A  thrpt    5       8282.043 ±       650.250  ops/s
Collections.addLinkedList                          N/A  thrpt    5        426.441 ±       506.106  ops/s
ParseInt.parseStringToIntIntegerParseInt        989819  thrpt    5   38528998.851 ±   3174047.673  ops/s
ParseInt.parseStringToIntIntegerParseInt         98989  thrpt    5   45634112.598 ±    740235.706  ops/s
ParseInt.parseStringToIntIntegerParseInt             1  thrpt    5  114523888.987 ±  12665338.318  ops/s
ParseInt.parseStringToIntIntegerParseInt             2  thrpt    5  112403321.377 ±  23572416.350  ops/s
ParseInt.parseStringToIntIntegerParseInt          3257  thrpt    5   51560868.307 ±   5702714.284  ops/s
ParseInt.parseStringToIntLuxoft                 989819  thrpt    5   46823703.234 ±  39919061.895  ops/s
ParseInt.parseStringToIntLuxoft                  98989  thrpt    5   59901335.214 ±  44627798.673  ops/s
ParseInt.parseStringToIntLuxoft                      1  thrpt    5   89070890.722 ±  18766051.946  ops/s
ParseInt.parseStringToIntLuxoft                      2  thrpt    5   90494881.079 ±   9107232.352  ops/s
ParseInt.parseStringToIntLuxoft                   3257  thrpt    5   58633518.974 ±   5615570.134  ops/s
ParseInt.parseStringToIntLuxoftChars            989819  thrpt    5  106546923.655 ±   5693582.592  ops/s
ParseInt.parseStringToIntLuxoftChars             98989  thrpt    5  127145781.991 ±   3628029.269  ops/s
ParseInt.parseStringToIntLuxoftChars                 1  thrpt    5  255161511.276 ±   4625606.860  ops/s
ParseInt.parseStringToIntLuxoftChars                 2  thrpt    5  255037851.609 ±   7798856.439  ops/s
ParseInt.parseStringToIntLuxoftChars              3257  thrpt    5  106280404.046 ±   9413544.598  ops/s
ParseInt.parseStringToIntLuxoftChars2           989819  thrpt    5   99798047.290 ±   4709399.035  ops/s
ParseInt.parseStringToIntLuxoftChars2            98989  thrpt    5  109383091.395 ±  47206208.022  ops/s
ParseInt.parseStringToIntLuxoftChars2                1  thrpt    5  245441168.237 ±  29648734.090  ops/s
ParseInt.parseStringToIntLuxoftChars2                2  thrpt    5  213705754.369 ± 205667848.983  ops/s
ParseInt.parseStringToIntLuxoftChars2             3257  thrpt    5  106892508.095 ±   3773465.658  ops/s
ParseInt.parseStringToIntLuxoftChars3           989819  thrpt    5  100860304.243 ±   2877778.940  ops/s
ParseInt.parseStringToIntLuxoftChars3            98989  thrpt    5  122551009.642 ±   6787436.614  ops/s
ParseInt.parseStringToIntLuxoftChars3                1  thrpt    5  253294491.884 ±   8128265.223  ops/s
ParseInt.parseStringToIntLuxoftChars3                2  thrpt    5  248389436.777 ±  36884084.552  ops/s
ParseInt.parseStringToIntLuxoftChars3             3257  thrpt    5   97800070.966 ±   5601637.149  ops/s
ParseInt.parseStringToIntLuxoftFori             989819  thrpt    5   77326748.099 ±   5006061.118  ops/s
ParseInt.parseStringToIntLuxoftFori              98989  thrpt    5   92124114.587 ±   8124485.012  ops/s
ParseInt.parseStringToIntLuxoftFori                  1  thrpt    5  145660057.805 ±   4831110.659  ops/s
ParseInt.parseStringToIntLuxoftFori                  2  thrpt    5  148367208.890 ±   3375909.069  ops/s
ParseInt.parseStringToIntLuxoftFori               3257  thrpt    5   71618463.914 ±    761967.632  ops/s
ParseInt.parseStringToIntLuxoftFori2            989819  thrpt    5   78868076.279 ±   8719883.154  ops/s
ParseInt.parseStringToIntLuxoftFori2             98989  thrpt    5   94160388.597 ±   5040858.196  ops/s
ParseInt.parseStringToIntLuxoftFori2                 1  thrpt    5  154873114.319 ±   3107547.708  ops/s
ParseInt.parseStringToIntLuxoftFori2                 2  thrpt    5  141438590.627 ±  55046807.954  ops/s
ParseInt.parseStringToIntLuxoftFori2              3257  thrpt    5   68576546.473 ±   7477426.344  ops/s
ParseInt.parseStringToIntReflectionGetChars     989819  thrpt    5   70249980.780 ±   2605777.428  ops/s
ParseInt.parseStringToIntReflectionGetChars      98989  thrpt    5   75803416.645 ±   3637282.152  ops/s
ParseInt.parseStringToIntReflectionGetChars          1  thrpt    5  124287961.743 ±  43844089.547  ops/s
ParseInt.parseStringToIntReflectionGetChars          2  thrpt    5  128714594.057 ±   1997948.347  ops/s
ParseInt.parseStringToIntReflectionGetChars       3257  thrpt    5   79360740.828 ±   1842589.360  ops/s
ParseInt.parseStringToIntStackOverflow          989819  thrpt    5   79085096.939 ±   6458620.076  ops/s
ParseInt.parseStringToIntStackOverflow           98989  thrpt    5   59643285.161 ±   2817316.597  ops/s
ParseInt.parseStringToIntStackOverflow               1  thrpt    5  308587200.995 ±   6891601.510  ops/s
ParseInt.parseStringToIntStackOverflow               2  thrpt    5  311430075.564 ±   6106104.883  ops/s
ParseInt.parseStringToIntStackOverflow            3257  thrpt    5   73424617.818 ±   1416749.036  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes     989819  thrpt    5    5017655.162 ±    152876.134  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes      98989  thrpt    5    5086670.894 ±    556610.996  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes          1  thrpt    5    5941952.346 ±   1157710.079  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes          2  thrpt    5    6191492.584 ±    163010.664  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes       3257  thrpt    5    5273212.851 ±    163699.210  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes      989819  thrpt    5   12042054.934 ±    517408.668  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes       98989  thrpt    5   12195956.767 ±   1647036.628  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes           1  thrpt    5   14165669.840 ±    323981.627  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes           2  thrpt    5   14058225.914 ±    401244.584  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes        3257  thrpt    5   12297020.064 ±    391340.017  ops/s
ParseInt.parseStringToIntUsingSwitch            989819  thrpt    5   40653489.850 ±   6027339.731  ops/s
ParseInt.parseStringToIntUsingSwitch             98989  thrpt    5   46383054.943 ±    553087.096  ops/s
ParseInt.parseStringToIntUsingSwitch                 1  thrpt    5   82409006.361 ±   4911430.468  ops/s
ParseInt.parseStringToIntUsingSwitch                 2  thrpt    5   77278510.372 ±   4601298.998  ops/s
ParseInt.parseStringToIntUsingSwitch              3257  thrpt    5   50115985.799 ±   6220313.424  ops/s
ParseInt.parseStringToIntUtf16Bytes             989819  thrpt    5  459008614.323 ±  45400136.308  ops/s
ParseInt.parseStringToIntUtf16Bytes              98989  thrpt    5  460416767.710 ±  25032900.019  ops/s
ParseInt.parseStringToIntUtf16Bytes                  1  thrpt    5  449974363.060 ±  30547694.565  ops/s
ParseInt.parseStringToIntUtf16Bytes                  2  thrpt    5  456016626.195 ±  54674267.993  ops/s
ParseInt.parseStringToIntUtf16Bytes               3257  thrpt    5  457908622.859 ±  21819668.919  ops/s
ParseInt.parseStringToIntUtf16Bytes2            989819  thrpt    5  554895821.693 ±  28744954.214  ops/s
ParseInt.parseStringToIntUtf16Bytes2             98989  thrpt    5  549825144.951 ±  42998034.307  ops/s
ParseInt.parseStringToIntUtf16Bytes2                 1  thrpt    5  525619199.683 ± 117209896.194  ops/s
ParseInt.parseStringToIntUtf16Bytes2                 2  thrpt    5  554314162.898 ±  36293017.129  ops/s
ParseInt.parseStringToIntUtf16Bytes2              3257  thrpt    5  553631721.924 ±  19057996.909  ops/s
ParseInt.parseStringToIntUtf16Bytes3            989819  thrpt    5  555805501.372 ±  14902149.851  ops/s
ParseInt.parseStringToIntUtf16Bytes3             98989  thrpt    5  548293369.354 ±  28735092.246  ops/s
ParseInt.parseStringToIntUtf16Bytes3                 1  thrpt    5  559902058.702 ±   8775787.530  ops/s
ParseInt.parseStringToIntUtf16Bytes3                 2  thrpt    5  545332685.911 ±  86478601.752  ops/s
ParseInt.parseStringToIntUtf16Bytes3              3257  thrpt    5  533295724.738 ±  63476109.755  ops/s
ParseInt.parseStringToIntUtf8Bytes              989819  thrpt    5   72718415.875 ±   1289761.968  ops/s
ParseInt.parseStringToIntUtf8Bytes               98989  thrpt    5   87298912.586 ±  15053073.928  ops/s
ParseInt.parseStringToIntUtf8Bytes                   1  thrpt    5  289297175.500 ±  74945855.615  ops/s
ParseInt.parseStringToIntUtf8Bytes                   2  thrpt    5  265387016.816 ±  95283822.394  ops/s
ParseInt.parseStringToIntUtf8Bytes                3257  thrpt    5   95180413.592 ±  21991037.888  ops/s
ParseInt.parseStringToIntUtf8Bytes2             989819  thrpt    5   88140367.571 ±  49794193.864  ops/s
ParseInt.parseStringToIntUtf8Bytes2              98989  thrpt    5   80781100.043 ± 117496438.578  ops/s
ParseInt.parseStringToIntUtf8Bytes2                  1  thrpt    5  220963613.063 ±  35770015.465  ops/s
ParseInt.parseStringToIntUtf8Bytes2                  2  thrpt    5  190750886.694 ±  80455313.219  ops/s
ParseInt.parseStringToIntUtf8Bytes2               3257  thrpt    5  120732201.540 ±  39137986.165  ops/s
ParseInt.parseStringToIntUtf8Bytes3             989819  thrpt    5   74528205.693 ±  45412085.594  ops/s
ParseInt.parseStringToIntUtf8Bytes3              98989  thrpt    5   94882869.974 ±  72075001.090  ops/s
ParseInt.parseStringToIntUtf8Bytes3                  1  thrpt    5  131887943.290 ± 145863328.233  ops/s
ParseInt.parseStringToIntUtf8Bytes3                  2  thrpt    5  117694340.429 ± 267813925.206  ops/s
ParseInt.parseStringToIntUtf8Bytes3               3257  thrpt    5   99373163.257 ± 139803347.606  ops/s

Benchmark result is saved to build\reports\jmh\results.txt
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8

BUILD SUCCESSFUL

Total time: 2 mins 22.216 secs

```
