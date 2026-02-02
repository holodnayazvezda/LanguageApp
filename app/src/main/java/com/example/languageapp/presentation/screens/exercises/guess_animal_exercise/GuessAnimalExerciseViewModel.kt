package com.example.languageapp.presentation.screens.exercises.guess_animal_exercise

import androidx.lifecycle.ViewModel
import com.example.languageapp.common.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class GuessAnimalExerciseViewModel : ViewModel() {
    private var _animalName = MutableStateFlow("")
    val animalName = _animalName.asStateFlow()
    private var _animalToGuess = MutableStateFlow(Constants.animals[0])
    val animalToGuess = _animalToGuess.asStateFlow()

    fun updateAnimal() {
        var newAnimal = Constants.animals.random()
        while (newAnimal.name == _animalToGuess.value.name) {
            newAnimal = Constants.animals.random()
        }
        _animalToGuess.value = newAnimal
        _animalName.value = ""
    }

    fun updateAnimalName(name: String) {
        _animalName.value = name
    }
    fun isCorrect(): Boolean {
        return _animalName.value.trim().lowercase(Locale.US) == _animalToGuess.value.name
    }

    init {
        updateAnimal()
    }
}