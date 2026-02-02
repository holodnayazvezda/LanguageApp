package com.example.languageapp.presentation.screens.exercises.audition_exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languageapp.common.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuditionExerciseViewModel(): ViewModel() {
    private var _word = MutableStateFlow(Constants.wordsToGuess[0])
    val word = _word.asStateFlow()
    private var _isRecording = MutableStateFlow(0)
    val isRecording = _isRecording.asStateFlow()
    private var _pronouncedWord = MutableStateFlow("")
    val pronouncedWord = _pronouncedWord.asStateFlow()

    fun updateWord() {
        var newWord = Constants.wordsToGuess.random()
        while (newWord.word == _word.value.word) {
            newWord = Constants.wordsToGuess.random()
        }
        _word.value = newWord
        _isRecording.value = 0
        _pronouncedWord.value = ""
    }

    fun startWordRecording() {
        _isRecording.value = 1
        viewModelScope.launch {
            var success = listOf(true, false).random()
            delay(3000)
            while (!success) {
                success = listOf(true, false).random()
                _pronouncedWord.value = _word.value.word
                    .replace("a", "o")
                    .replace("e", "i")
                    .replace("c", "k")
                    .replace("t", "d")
                    .replace("s", "z")
                delay(2000)
            }
            _pronouncedWord.value = _word.value.word
            _isRecording.value = -1
        }
    }

    init {
        updateWord()
    }
}