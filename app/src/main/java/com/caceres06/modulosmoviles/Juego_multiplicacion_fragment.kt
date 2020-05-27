package com.caceres06.modulosmoviles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.caceres06.modulosmoviles.databinding.FragmentJuegoMultiplicacionFragmentBinding


/**
 * A simple [Fragment] subclass.
 */
class Juego_multiplicacion_fragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>
    )
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "10 x 1",
            answers = listOf("10","7","4")
        ),
        Question(
            text = "4 x 2",
            answers = listOf("8","10","4")
        ),
        Question(
            text = "3 x 3",
            answers = listOf("9","0","4")
        ),
        Question(
            text = "2 x 3",
            answers = listOf("6","5","4")
        )


    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var score = 0
    private val numQuestions = 4
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding= DataBindingUtil.inflate<FragmentJuegoMultiplicacionFragmentBinding>(inflater,R.layout.fragment_juego_multiplicacion_fragment,container,false)
        randomizeQuestions()
        binding.game = this

        binding.button2.setOnClickListener{

            if(answers[0] == currentQuestion.answers[0]){
                score++
                questionIndex++
                if (questionIndex < numQuestions) {

                    setQuestion()

                    binding.invalidateAll()

                }else{

                    it.findNavController().navigate(Juego_multiplicacion_fragmentDirections.actionJuegoMultiplicacionFragmentToWon(score))
                }
            }else{
                Toast.makeText(context,"Respuesta Erronea", Toast.LENGTH_SHORT).show()
                questionIndex++
                if (questionIndex < numQuestions) {

                    setQuestion()

                    binding.invalidateAll()

                }else{

                    it.findNavController().navigate(Juego_multiplicacion_fragmentDirections.actionJuegoMultiplicacionFragmentToWon(score))
                }
            }

        }
        binding.button3.setOnClickListener{

            if(answers[1] == currentQuestion.answers[0]){
                score++
                questionIndex++
                if (questionIndex < numQuestions) {

                    setQuestion()

                    binding.invalidateAll()

                }else{

                    it.findNavController().navigate(Juego_multiplicacion_fragmentDirections.actionJuegoMultiplicacionFragmentToWon(score))
                }
            }else{
                Toast.makeText(context,"Respuesta Erronea", Toast.LENGTH_SHORT).show()
                questionIndex++
                if (questionIndex < numQuestions) {

                    setQuestion()

                    binding.invalidateAll()

                }else{

                    it.findNavController().navigate(Juego_multiplicacion_fragmentDirections.actionJuegoMultiplicacionFragmentToWon(score))
                }
            }

        }
        binding.button4.setOnClickListener{

            if(answers[2] == currentQuestion.answers[0]){
                score++
                questionIndex++
                if (questionIndex < numQuestions) {

                    setQuestion()

                    binding.invalidateAll()

                }else{

                    it.findNavController().navigate(Juego_multiplicacion_fragmentDirections.actionJuegoMultiplicacionFragmentToWon(score))
                }
            }else{
                Toast.makeText(context,"Respuesta Erronea", Toast.LENGTH_SHORT).show()
                questionIndex++
                if (questionIndex < numQuestions) {

                    setQuestion()

                    binding.invalidateAll()

                }else{

                    it.findNavController().navigate(Juego_multiplicacion_fragmentDirections.actionJuegoMultiplicacionFragmentToWon(score))
                }
            }

        }

        return binding.root
    }
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]

        answers = currentQuestion.answers.toMutableList()

        answers.shuffle()

        (activity as AppCompatActivity)
            .supportActionBar?.title = getString(R.string.actions,questionIndex+1,numQuestions)

    }


}
