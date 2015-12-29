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
# Run complete. Total time: 00:02:18

Benchmark                                    (toParse)   Mode  Cnt          Score           Error  Units
Collections.addArrayList                           N/A  thrpt    5       8197.923 ±      2250.414  ops/s
Collections.addLinkedList                          N/A  thrpt    5        493.983 ±       588.747  ops/s
ParseInt.parseStringToIntIntegerParseInt        989819  thrpt    5   36931127.042 ±  10201831.756  ops/s
ParseInt.parseStringToIntIntegerParseInt         98989  thrpt    5   42854038.287 ±  15733501.067  ops/s
ParseInt.parseStringToIntIntegerParseInt             1  thrpt    5  115214896.243 ±   4547850.959  ops/s
ParseInt.parseStringToIntIntegerParseInt             2  thrpt    5  113417415.022 ±  20956844.279  ops/s
ParseInt.parseStringToIntIntegerParseInt          3257  thrpt    5   49692765.895 ±  13608722.719  ops/s
ParseInt.parseStringToIntLuxoft                 989819  thrpt    5   39901541.606 ±  41610874.411  ops/s
ParseInt.parseStringToIntLuxoft                  98989  thrpt    5   59701008.359 ±  29775664.510  ops/s
ParseInt.parseStringToIntLuxoft                      1  thrpt    5   88067306.434 ±  13371747.543  ops/s
ParseInt.parseStringToIntLuxoft                      2  thrpt    5   84573546.416 ±  26281168.878  ops/s
ParseInt.parseStringToIntLuxoft                   3257  thrpt    5   53670404.270 ±  39644568.582  ops/s
ParseInt.parseStringToIntLuxoftChars            989819  thrpt    5   92549452.744 ±  59025589.675  ops/s
ParseInt.parseStringToIntLuxoftChars             98989  thrpt    5  121730592.169 ±  19321428.346  ops/s
ParseInt.parseStringToIntLuxoftChars                 1  thrpt    5  248084949.943 ±  37519062.379  ops/s
ParseInt.parseStringToIntLuxoftChars                 2  thrpt    5  246040048.153 ±  27389064.250  ops/s
ParseInt.parseStringToIntLuxoftChars              3257  thrpt    5  103347441.077 ±  21823465.451  ops/s
ParseInt.parseStringToIntLuxoftChars2           989819  thrpt    5   77701466.999 ±  42354872.840  ops/s
ParseInt.parseStringToIntLuxoftChars2            98989  thrpt    5  111272811.955 ±  28263601.949  ops/s
ParseInt.parseStringToIntLuxoftChars2                1  thrpt    5  251964857.888 ±   5858499.390  ops/s
ParseInt.parseStringToIntLuxoftChars2                2  thrpt    5  246329844.526 ±  43228244.359  ops/s
ParseInt.parseStringToIntLuxoftChars2             3257  thrpt    5  101029004.480 ±  34194852.924  ops/s
ParseInt.parseStringToIntLuxoftChars3           989819  thrpt    5  100489979.190 ±   1168668.270  ops/s
ParseInt.parseStringToIntLuxoftChars3            98989  thrpt    5  119397664.717 ±  28035517.755  ops/s
ParseInt.parseStringToIntLuxoftChars3                1  thrpt    5  247455550.938 ±  35524834.443  ops/s
ParseInt.parseStringToIntLuxoftChars3                2  thrpt    5  251304284.968 ±   5004399.078  ops/s
ParseInt.parseStringToIntLuxoftChars3             3257  thrpt    5   91669274.331 ±  28748982.901  ops/s
ParseInt.parseStringToIntLuxoftFori             989819  thrpt    5   75522395.475 ±  18827897.664  ops/s
ParseInt.parseStringToIntLuxoftFori              98989  thrpt    5   90696563.593 ±   3036594.340  ops/s
ParseInt.parseStringToIntLuxoftFori                  1  thrpt    5  146093366.057 ±   2262174.479  ops/s
ParseInt.parseStringToIntLuxoftFori                  2  thrpt    5  142068006.819 ±  33141885.933  ops/s
ParseInt.parseStringToIntLuxoftFori               3257  thrpt    5   67807509.123 ±  16747269.350  ops/s
ParseInt.parseStringToIntLuxoftFori2            989819  thrpt    5   77196989.407 ±    295324.439  ops/s
ParseInt.parseStringToIntLuxoftFori2             98989  thrpt    5   91012354.086 ±  21643243.759  ops/s
ParseInt.parseStringToIntLuxoftFori2                 1  thrpt    5  150307442.659 ±  22397879.631  ops/s
ParseInt.parseStringToIntLuxoftFori2                 2  thrpt    5  153737208.111 ±   5610806.110  ops/s
ParseInt.parseStringToIntLuxoftFori2              3257  thrpt    5   61028634.350 ±  19711591.574  ops/s
ParseInt.parseStringToIntReflectionGetChars     989819  thrpt    5   71526045.917 ±    976693.130  ops/s
ParseInt.parseStringToIntReflectionGetChars      98989  thrpt    5   72405380.611 ±  22257913.849  ops/s
ParseInt.parseStringToIntReflectionGetChars          1  thrpt    5  126921153.362 ±    982924.879  ops/s
ParseInt.parseStringToIntReflectionGetChars          2  thrpt    5  124486045.934 ±  27727856.668  ops/s
ParseInt.parseStringToIntReflectionGetChars       3257  thrpt    5   64135871.781 ±  76976405.536  ops/s
ParseInt.parseStringToIntStackOverflow          989819  thrpt    5   79301507.633 ±    661768.473  ops/s
ParseInt.parseStringToIntStackOverflow           98989  thrpt    5   55887983.968 ±  16223898.495  ops/s
ParseInt.parseStringToIntStackOverflow               1  thrpt    5  308619046.131 ±   2349487.842  ops/s
ParseInt.parseStringToIntStackOverflow               2  thrpt    5  292755880.782 ±  79375747.132  ops/s
ParseInt.parseStringToIntStackOverflow            3257  thrpt    5   72456853.781 ±   2776885.534  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes     989819  thrpt    5    3860262.074 ±   2005922.441  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes      98989  thrpt    5    4563287.200 ±   1227100.525  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes          1  thrpt    5    5950014.356 ±    281969.621  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes          2  thrpt    5    5289120.495 ±   2232856.710  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes       3257  thrpt    5    4531406.142 ±   1991893.803  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes      989819  thrpt    5    9954988.977 ±  12218951.867  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes       98989  thrpt    5   12001300.370 ±   3251738.720  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes           1  thrpt    5   13224007.459 ±   5021705.201  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes           2  thrpt    5   13576618.482 ±   1075995.035  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes        3257  thrpt    5   11313546.322 ±   5962638.092  ops/s
ParseInt.parseStringToIntUsingSwitch            989819  thrpt    5   35888731.441 ±   9373630.650  ops/s
ParseInt.parseStringToIntUsingSwitch             98989  thrpt    5   45174084.758 ±  10201779.019  ops/s
ParseInt.parseStringToIntUsingSwitch                 1  thrpt    5   78018567.731 ±  18959151.142  ops/s
ParseInt.parseStringToIntUsingSwitch                 2  thrpt    5   80045697.580 ±   1782011.764  ops/s
ParseInt.parseStringToIntUsingSwitch              3257  thrpt    5   45820338.594 ±  23836331.065  ops/s
ParseInt.parseStringToIntUtf16Bytes             989819  thrpt    5   56490786.922 ±  22561681.331  ops/s
ParseInt.parseStringToIntUtf16Bytes              98989  thrpt    5   61409962.677 ±   9483542.490  ops/s
ParseInt.parseStringToIntUtf16Bytes                  1  thrpt    5  110969623.518 ±  30002799.604  ops/s
ParseInt.parseStringToIntUtf16Bytes                  2  thrpt    5  120758587.133 ±   3166577.783  ops/s
ParseInt.parseStringToIntUtf16Bytes               3257  thrpt    5   66862720.484 ±  39010882.727  ops/s
ParseInt.parseStringToIntUtf16Bytes2            989819  thrpt    5   57590078.823 ±  13106029.948  ops/s
ParseInt.parseStringToIntUtf16Bytes2             98989  thrpt    5   62543322.550 ±   2566290.474  ops/s
ParseInt.parseStringToIntUtf16Bytes2                 1  thrpt    5  112108656.329 ±  48476772.389  ops/s
ParseInt.parseStringToIntUtf16Bytes2                 2  thrpt    5  118980663.333 ±  11243598.077  ops/s
ParseInt.parseStringToIntUtf16Bytes2              3257  thrpt    5   76471084.903 ±   4015783.694  ops/s
ParseInt.parseStringToIntUtf16Bytes3            989819  thrpt    5   58416708.574 ±   3954618.941  ops/s
ParseInt.parseStringToIntUtf16Bytes3             98989  thrpt    5   61717897.497 ±   7590529.376  ops/s
ParseInt.parseStringToIntUtf16Bytes3                 1  thrpt    5  132214453.510 ±   1133834.134  ops/s
ParseInt.parseStringToIntUtf16Bytes3                 2  thrpt    5  115739055.243 ± 101937056.927  ops/s
ParseInt.parseStringToIntUtf16Bytes3              3257  thrpt    5   74333069.919 ±  25616089.185  ops/s
ParseInt.parseStringToIntUtf8Bytes              989819  thrpt    5  102619804.227 ±   1817064.954  ops/s
ParseInt.parseStringToIntUtf8Bytes               98989  thrpt    5  120228415.769 ±   3392064.528  ops/s
ParseInt.parseStringToIntUtf8Bytes                   1  thrpt    5  241623466.618 ±  59925151.592  ops/s
ParseInt.parseStringToIntUtf8Bytes                   2  thrpt    5  207366226.760 ± 137097974.898  ops/s
ParseInt.parseStringToIntUtf8Bytes                3257  thrpt    5   99896064.563 ±  35359639.423  ops/s
ParseInt.parseStringToIntUtf8Bytes2             989819  thrpt    5   95544481.544 ±  40154848.693  ops/s
ParseInt.parseStringToIntUtf8Bytes2              98989  thrpt    5  106216520.237 ±  74979402.999  ops/s
ParseInt.parseStringToIntUtf8Bytes2                  1  thrpt    5  252266059.649 ±   2415711.628  ops/s
ParseInt.parseStringToIntUtf8Bytes2                  2  thrpt    5  228805008.013 ± 116876539.818  ops/s
ParseInt.parseStringToIntUtf8Bytes2               3257  thrpt    5  107201851.001 ±   2376114.282  ops/s
ParseInt.parseStringToIntUtf8Bytes3             989819  thrpt    5   81607064.284 ±  89274705.134  ops/s
ParseInt.parseStringToIntUtf8Bytes3              98989  thrpt    5  108273033.062 ±  78379926.038  ops/s
ParseInt.parseStringToIntUtf8Bytes3                  1  thrpt    5  252210702.288 ±   4808089.081  ops/s
ParseInt.parseStringToIntUtf8Bytes3                  2  thrpt    5  239397833.357 ±  70548670.330  ops/s
ParseInt.parseStringToIntUtf8Bytes3               3257  thrpt    5   90308598.160 ±  33644435.682  ops/s

Benchmark result is saved to build\reports\jmh\results.txt
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8

BUILD SUCCESSFUL

Total time: 2 mins 20.373 secs
```
