package com.example.languageapp.presentation.screens.exercises.word_practice_exercise

import androidx.lifecycle.ViewModel
import com.example.languageapp.common.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.listOf

class WordPracticeExerciseViewModel(
): ViewModel() {
    private var _word = MutableStateFlow(Constants.wordsToGuess[0])
    val word = _word.asStateFlow()
    private var _wordsToGuess = MutableStateFlow(listOf<String>())
    val wordToGuess = _wordsToGuess.asStateFlow()
    private var _selectedWord = MutableStateFlow("")
    val selectedWord = _selectedWord.asStateFlow()
    private var _checkResult = MutableStateFlow(0)
    val checkResult = _checkResult.asStateFlow()

    fun updateSelectedWord(word: String) {
        _selectedWord.value = word
    }

    fun check() {
        if (_selectedWord.value == _word.value.translation) {
            _checkResult.value = 1
        } else {
            _checkResult.value = -1
        }
    }

    fun updateWord() {
        var newWord = Constants.wordsToGuess.random()
        while (newWord.word == _word.value.word) {
            newWord = Constants.wordsToGuess.random()
        }
        _word.value = newWord
        val availableVariants = Constants.randomRussianWords.take(3).toMutableList()
        availableVariants.add(_word.value.translation)
        val availableVariantsShuffled = availableVariants.toList().shuffled()
        _wordsToGuess.value = availableVariantsShuffled
        _checkResult.value = 0
        _selectedWord.value = ""
    }

    init {
        updateWord()
    }
}