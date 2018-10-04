package com.ihsmarkit.code.kata;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class CommonDenominators {

    public static void main(final String... args) {
        System.out.println("(6,12)(4,12)(3,12)".equals(convertFracs(new long[][]{{1, 2}, {1, 3}, {1, 4}})));

        System.out.println("(13,104)(16,104)".equals(convertFracs(new long[][]{{1, 8}, {2, 13}})));

        System.out.println("(3,24)(2,24)".equals(convertFracs(new long[][]{{1, 8}, {2, 24}})));

        System.out.println("(5,5)(3,5)".equals(convertFracs(new long[][]{{1, 1}, {3, 5}})));

        System.out.println("(2,12)(2,12)".equals(convertFracs(new long[][]{{1, 6}, {2, 12}})));

        System.out.println("(0,60)(30,60)(20,60)(15,60)(12,60)".equals(convertFracs(new long[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}})));

        System.out.println("(12,60)(0,60)(30,60)(20,60)(15,60)".equals(convertFracs(new long[][]{{1, 5}, {0, 1}, {1, 2}, {1, 3}, {1, 4}})));
    }


    public static String convertFracs(final long[][] numberToDenominatorArray) {
        final Set<Double> denominators = new TreeSet<>(reverseOrder());

        final long leastDenominator = (long) stream(numberToDenominatorArray)
                .filter(numberAndDenominator -> numberAndDenominator[1] != 1)
                .mapToDouble(numberAndDenominator -> {
                    final double currentDenom = numberAndDenominator[1];

                    if (!denominators.isEmpty()) {
                        final Optional<Double> optionalExistingDenom = denominators.stream()
                                .filter(denom -> denom > currentDenom ? denom % currentDenom == 0 : currentDenom % denom == 0)
                                .findFirst();

                        if (optionalExistingDenom.isPresent()) {
                            final double existingDenom = optionalExistingDenom.get();
                            if (existingDenom > currentDenom) {
                                denominators.add(currentDenom);
                                return currentDenom * (currentDenom / existingDenom);
                            } else if (existingDenom < currentDenom) {
                                denominators.add(currentDenom);
                                return currentDenom / existingDenom;
                            }
                            return 1;
                        }
                    }
                    denominators.add(currentDenom);
                    return currentDenom;
                })
                .reduce(1, (d1, d2) -> d1 * d2);

        return join("", stream(numberToDenominatorArray)
                .map(numberAndDenominator -> format("(%d,%d)", numberAndDenominator[0] * (leastDenominator / numberAndDenominator[1]), leastDenominator))
                .collect(toList()));
    }

}
