package net.mirwaldt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSaySequencerTest {
    private static Stream<Arguments> lookAndSaySequencer() {
        return Stream.of(Arguments.of(new DefaultLookAndSaySequencer()));
    }

    @ParameterizedTest
    @MethodSource("lookAndSaySequencer")
    void test_sequence_noApplication(LookAndSaySequencer lookAndSaySequencer) {
        assertEquals("11", lookAndSaySequencer.sequenceLookAndSay("11", 0));
        assertEquals("21", lookAndSaySequencer.sequenceLookAndSay("21", 0));
    }

    @ParameterizedTest
    @MethodSource("lookAndSaySequencer")
    void test_sequence_oneApplication(LookAndSaySequencer lookAndSaySequencer) {
        assertEquals("21", lookAndSaySequencer.sequenceLookAndSay("11", 1));
        assertEquals("1211", lookAndSaySequencer.sequenceLookAndSay("21", 1));
    }

    @ParameterizedTest
    @MethodSource("lookAndSaySequencer")
    void test_sequence_twoApplications(LookAndSaySequencer lookAndSaySequencer) {
        assertEquals("1211", lookAndSaySequencer.sequenceLookAndSay("11", 2));
        assertEquals("111221", lookAndSaySequencer.sequenceLookAndSay("21", 2));
    }

    @ParameterizedTest
    @MethodSource("lookAndSaySequencer")
    void test_sequence_threeApplications(LookAndSaySequencer lookAndSaySequencer) {
        assertEquals("111221", lookAndSaySequencer.sequenceLookAndSay("11", 3));
        assertEquals("312211", lookAndSaySequencer.sequenceLookAndSay("21", 3));
    }

    @ParameterizedTest
    @MethodSource("lookAndSaySequencer")
    void test_sequence_fiveApplications(LookAndSaySequencer lookAndSaySequencer) {
        assertEquals("1113213211", lookAndSaySequencer.sequenceLookAndSay("11", 5));
    }
}
