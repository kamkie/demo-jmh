# demo-jmh

to run benchmarks
```
gradlew clean jmh
```

#Benchmarks

##Collections
this benchmarks show difference betwean standard java List implementations

##ParseInt
this benchmarks show difference betwean different implementations of prsing int in Java

###parseStringToIntIntegerParseInt
using Integer.parseInt
supports negative values, throws exeption if string is not valid integer

###parseStringToIntLuxoft
using code from email I got
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntReflectionGetChars
get char array using reflection instead toCharArray to avoid coping array
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftFori
using code from email I got, with change to charAt
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftFori2
using code from email I got, with change to charAt and local variable inside loop
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftChars
for loop on char array
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftChars2
fori loop on char array
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntLuxoftChars3
fori loop on char array and local variable inside loop
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntStackOverflow
implementation found on StackOverflow
supports negative values, throws exeption if string is not valid integer

###parseStringToIntUtf8Bytes
for loop on byte array
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntUtf8Bytes2
fori loop on byte array
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntUtf8Bytes3
fori loop on byte array and local variable inside loop
supports only pozitive values, returns -1 if string is not valid integer

###parseStringToIntUtf8Bytes3
fori loop on byte array and local variable inside loop
supports only pozitive values, returns -1 if string is not valid integer


#example result
```
Benchmark                                     Mode  Cnt          Score         Error  Units
Collections.addArrayList                     thrpt    5       8545.633 ±     280.879  ops/s
Collections.addLinkedList                    thrpt    5        494.747 ±     587.360  ops/s
ParseInt.parseStringToIntIntegerParseInt     thrpt   20   45361111.994 ±  571524.217  ops/s
ParseInt.parseStringToIntLuxoft              thrpt   20   65035605.493 ± 1676701.660  ops/s
ParseInt.parseStringToIntLuxoftChars         thrpt   20  127984661.578 ±  686270.178  ops/s
ParseInt.parseStringToIntLuxoftChars2        thrpt   20  116083416.253 ±  997521.720  ops/s
ParseInt.parseStringToIntLuxoftChars3        thrpt   20  123215432.763 ± 1032402.616  ops/s
ParseInt.parseStringToIntLuxoftFori          thrpt   20   91297287.810 ± 2156350.505  ops/s
ParseInt.parseStringToIntLuxoftFori2         thrpt   20   94192752.953 ± 2892089.995  ops/s
ParseInt.parseStringToIntReflectionGetChars  thrpt   20   74772407.909 ± 2259847.006  ops/s
ParseInt.parseStringToIntStackOverflow       thrpt   20   57719488.390 ±  412721.753  ops/s
ParseInt.parseStringToIntStringToUtf16Bytes  thrpt   20    6333505.998 ±  127096.815  ops/s
ParseInt.parseStringToIntStringToUtf8Bytes   thrpt   20   11068361.981 ±   99923.510  ops/s
ParseInt.parseStringToIntUsingSwitch         thrpt   20   46232461.189 ±  323894.266  ops/s
ParseInt.parseStringToIntUtf16Bytes          thrpt   20  461456299.921 ± 5805999.479  ops/s
ParseInt.parseStringToIntUtf8Bytes           thrpt   20   89778866.734 ±  736595.744  ops/s
ParseInt.parseStringToIntUtf8Bytes2          thrpt   20  118149892.753 ± 1255313.602  ops/s
ParseInt.parseStringToIntUtf8Bytes3          thrpt   20  120870082.580 ± 1866769.752  ops/s

Benchmark result is saved to build\reports\jmh\results.txt
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8

BUILD SUCCESSFUL

Total time: 10 mins 45.425 secs
```
