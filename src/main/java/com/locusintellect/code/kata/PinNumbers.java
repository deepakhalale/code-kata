package com.locusintellect.code.kata;

import static com.google.common.collect.ImmutableList.of;
import static com.google.common.collect.Lists.cartesianProduct;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

public class PinNumbers {


    public static void main(final String... args) {
        System.out.println(getPINs("8"));
        System.out.println(getPINs("11"));
        System.out.println(getPINs("369"));
    }

    public static List<String> getPINs(final String observed) {
        final Map<Character, List<String>> keyWithAdjacentPositions = getKeyWithAdjacentDigits();

        final List<List<String>> listOfList = observed.chars()
                .mapToObj(i -> (char) i)
                .map(digit -> {
                    final List<String> adjacentWithActualDigits = newArrayList(keyWithAdjacentPositions.get(digit));
                    adjacentWithActualDigits.add(digit.toString());
                    return adjacentWithActualDigits;
                })
                .collect(toList());

        return cartesianProduct(listOfList).stream()
                .map(digits -> String.join("", digits))
                .collect(toList());
    }

    private static Map<Character, List<String>> getKeyWithAdjacentDigits() {
        final Map<Character, List<String>> keyWithAdjacentPositions = newHashMap();
        keyWithAdjacentPositions.put('1', of("2", "4"));
        keyWithAdjacentPositions.put('2', of("1", "3", "5"));
        keyWithAdjacentPositions.put('3', of("2", "6"));
        keyWithAdjacentPositions.put('4', of("1", "5", "7"));
        keyWithAdjacentPositions.put('5', of("2", "4", "6", "8"));
        keyWithAdjacentPositions.put('6', of("3", "5", "9"));
        keyWithAdjacentPositions.put('7', of("4", "8"));
        keyWithAdjacentPositions.put('8', of("5", "7", "9", "0"));
        keyWithAdjacentPositions.put('9', of("6", "8"));
        keyWithAdjacentPositions.put('0', of("8"));

        return keyWithAdjacentPositions;
    }

}
