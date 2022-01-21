package net.mirwaldt.aoc.year2015.day10;

public class DefaultLookAndSaySequencer implements LookAndSaySequencer {
    @Override
    public String sequenceLookAndSay(String lookAndSaySequence, int applications) {
        String appliedLookAndSaySequence = lookAndSaySequence;
        for (int application = 0; application < applications; application++) {
            final StringBuilder currentLookAndSaySequence = applyLookAndSay(appliedLookAndSaySequence);
            appliedLookAndSaySequence = currentLookAndSaySequence.toString();
        }
        return appliedLookAndSaySequence;
    }

    private StringBuilder applyLookAndSay(String appliedLookAndSaySequence) {
        final StringBuilder currentLookAndSaySequence = new StringBuilder();
        for (int firstIndex = 0; firstIndex < appliedLookAndSaySequence.length(); ) {
            firstIndex += findAndApplyLookAndSay(appliedLookAndSaySequence, currentLookAndSaySequence, firstIndex);
        }
        return currentLookAndSaySequence;
    }

    private int findAndApplyLookAndSay(
            String appliedLookAndSaySequence, StringBuilder currentLookAndSaySequence, int firstIndex) {
        final String digitAsString = appliedLookAndSaySequence.substring(firstIndex, firstIndex + 1);
        final int lastIndex = findLastIndex(appliedLookAndSaySequence, firstIndex, digitAsString);
        final int count = lastIndex - firstIndex;
        addToCurrentLookAndSaySequence(currentLookAndSaySequence, digitAsString, count);
        return count;
    }

    private void addToCurrentLookAndSaySequence(
            StringBuilder currentLookAndSaySequence, String digitAsString, int count) {
        currentLookAndSaySequence.append(count);
        currentLookAndSaySequence.append(digitAsString);
    }

    private int findLastIndex(String appliedLookAndSaySequence, int firstIndex, String digitAsString) {
        int lastIndex = firstIndex + 1;
        for (; lastIndex < appliedLookAndSaySequence.length(); lastIndex++) {
            if (breakIfDigitFound(appliedLookAndSaySequence, digitAsString, lastIndex)) {
                break;
            }
        }
        return lastIndex;
    }

    private boolean breakIfDigitFound(String lookAndSaySequence, String digitAsString, int lastIndex) {
        final String nextDigitAsString = lookAndSaySequence.substring(lastIndex, lastIndex + 1);
        return !nextDigitAsString.equals(digitAsString);
    }
}
