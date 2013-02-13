#!/bin/sh

echo "Solution | Expected"

echo "\nTest 1.0\n"
java SpreadSheet 1-0.csv > 1-0.out
diff -sywB --suppress-common-lines 1-0.sol 1-0.out

echo "\nTest 1.1\n"
java SpreadSheet 1-1.csv > 1-1.out
diff -sywB --suppress-common-lines 1-1.csv 1-1.out

echo "\nTest 2.0\n"
java SpreadSheet 2-0.csv > 2-0.out
diff -sywB --suppress-common-lines 2-0.sol 2-0.out

echo "\nTest  3.0\n"
java SpreadSheet 3-0.csv > 3-0.out
diff -sywB --suppress-common-lines 3-0.sol 3-0.out

echo "\nTest 4\n"
java SpreadSheet 4-0.csv > 4-0.out
diff -sywB --suppress-common-lines 4-0.sol 4-0.out

echo "\nTest 4.1\n"
java SpreadSheet 4-1.csv > 4-1.out
diff -sywB --suppress-common-lines 4-1.sol 4-1.out

echo "\nTest 5.0\n"
java SpreadSheet 5-0.csv > 5-0.out
diff -sywB --suppress-common-lines 5-0.sol 5-0.out

echo "\nTest 5.1\n"
java SpreadSheet 5-1.csv > 5-1.out
diff -sywB --suppress-common-lines 5-1.sol 5-1.out

echo "\nTest 5.2\n"
java SpreadSheet 5-2.csv > 5-2.out
diff -sywB --suppress-common-lines 5-2.sol 5-2.out
