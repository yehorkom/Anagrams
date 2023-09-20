package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ReversionTest {

    @Test
    void testSplitAndRevers() {
        String inputString = "a1bcd efg!h";
        String expectedResult = "d1cba hgf!e";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void testReverseWord() {
        char[] input = {'a', '1', 'b', 'c', 'd'};
        assertEquals("d1cba",Reversion.reverseWord(input) );
    }

    @Test
    void testReverse() {
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] expectedArray = {'f', 'e', 'd', 'c', 'b', 'a'};
        Reversion.reverse(input,input.length);
        assertArrayEquals(expectedArray,input);
    }

    @Test
    void testAddNonLetter() {
        char[] reversedArray = {'d', 'c', 'b', 'a', ' '};
        char[] originalArray = {'a', '1', 'b', 'c', 'd'};
        char[] expectedArray = {'d','1', 'c', 'b', 'a'};
        Reversion.addNonLetter(originalArray,reversedArray);
        assertArrayEquals(expectedArray,originalArray);
    }

    @Test
    void When_InputVariableEmpty_Expect_ThrowException(){
        String inputString = "";
        assertThrows(IllegalArgumentException.class, ()-> { Reversion.splitAndRevers(inputString);} );
    }

    @Test
    void When_InputSpace_Expect_OutputSpace() {
        String inputString = " ";
        String expectedResult = " ";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputTwoSpace_Expect_OutputTwoSpace() {
        String inputString = "  ";
        String expectedResult = "  ";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputOneCharacter_Expect_OneCharacterOutput() {
        String inputString = "b";
        String expectedResult = "b";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputSeveralSameLetter_Expect_OutputSameLetter() {
        String inputString = "aaaaa";
        String expectedResult = "aaaaa";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputSameCharacterInMixedCases_Expect_OutputReversedInput() {
        String inputString = "AabB";
        String expectedResult = "BbaA";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputWord_Expect_OutputReversedWord() {
        String inputString = "hello";
        String expectedResult = "olleh";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputOnlySymbols_Expect_OutputNotReversedSymbols() {
        String inputString = "1!/";
        String expectedResult = "1!/";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @Test
    void When_InputSeveralWords_Expect_OutputReversedWords() {
        String inputString = "hello is java test";
        String expectedResult = "olleh si avaj tset";
        assertEquals(expectedResult,Reversion.splitAndRevers(inputString));
    }

    @AfterAll
    static void afterAll(){
        System.out.println("All test pass");
    }
}

