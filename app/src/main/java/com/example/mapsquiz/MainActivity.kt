package com.example.mapsquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mapsquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var quizModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList = mutableListOf()
        getDataFromFirebase()
    }

    private fun setupRecyclerView() {
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getDataFromFirebase() {
        // dummy data

        val listQuestionModel = mutableListOf<QuestionModel>()
        listQuestionModel.add(QuestionModel("What is the capital of France?", mutableListOf("London", "Berlin", "Paris", "Madrid"),"Paris"))
        listQuestionModel.add(QuestionModel("What is the capital of Japan?", mutableListOf("Seoul", "Beijing", "Bangkok", "Tokyo"),"Tokyo"))
        listQuestionModel.add(QuestionModel("What is the capital of Australia?", mutableListOf("Sydney", "Melbourne", "Canberra", "Perth"),"Canberra"))

        quizModelList.add(QuizModel("1", "Capital", "All the capitals", "10", listQuestionModel))
//        quizModelList.add(QuizModel("2", "Flags", "All the flags", "10", listQuestionModel))
//        quizModelList.add(QuizModel("3", "Continents", "All the continents", "10", listQuestionModel))
//        quizModelList.add(QuizModel("4", "Language & Currency", "All the language & currency", "10", listQuestionModel))
        setupRecyclerView()
    }
}