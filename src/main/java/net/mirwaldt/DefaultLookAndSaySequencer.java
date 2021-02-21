package net.mirwaldt;

public class DefaultLookAndSaySequencer implements LookAndSaySequencer {
    @Override
    public String sequenceLookAndSay(String lookAndSaySequence, int applications) {
        String appliedLookAndSaySequence = lookAndSaySequence;
        for (int application = 0; application < applications; application++) {
            final StringBuilder currentLookAndSaySequence = new StringBuilder();
            for (int firstIndex = 0; firstIndex < appliedLookAndSaySequence.length(); ) {
                final String digitAsString = appliedLookAndSaySequence.substring(firstIndex, firstIndex + 1);
                final int digit = Integer.parseInt(digitAsString);
                int lastIndex = firstIndex + 1;
                for (; lastIndex < appliedLookAndSaySequence.length(); lastIndex++) {
                    final String nextDigitAsString = appliedLookAndSaySequence.substring(lastIndex, lastIndex + 1);
                    if (!nextDigitAsString.equals(digitAsString)) {
                        break;
                    }
                }
                final int count = lastIndex - firstIndex;
                currentLookAndSaySequence.append(count);
                currentLookAndSaySequence.append(digit);
                firstIndex += count;
            }
            appliedLookAndSaySequence = currentLookAndSaySequence.toString();
        }
        return appliedLookAndSaySequence;
    }
}
