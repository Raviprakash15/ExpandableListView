package com.ravi.expandablelistview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.keabis.expandablelistview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listHeader = ArrayList<LstHeaderModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setData()
        binding.expandableRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = HeaderAdapter(context, listHeader) { listItem, position ->
                Toast.makeText(context, "Clicked ${listItem.name}", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun setData(): List<LstHeaderModel> {
        listHeader.add(
            LstHeaderModel(
                "Tower1", 7, listOf<LstSubHeader>(
                    LstSubHeader("1st Floor"),
                    LstSubHeader("2nd Floor"),
                    LstSubHeader("3rd Floor"),
                    LstSubHeader("4th Floor"),
                    LstSubHeader("5th Floor"),
                    LstSubHeader("6th Floor"),
                    LstSubHeader("7th Floor")
                )
            )
        )
        listHeader.add(
            LstHeaderModel(
                "Tower2", 8, listOf<LstSubHeader>(
                    LstSubHeader("1st Floor"),
                    LstSubHeader("2nd Floor"),
                    LstSubHeader("3rd Floor"),
                    LstSubHeader("4th Floor"),
                    LstSubHeader("5th Floor"),
                    LstSubHeader("6th Floor"),
                    LstSubHeader("7th Floor"),
                    LstSubHeader("8th Floor")
                )
            )
        )
        return listHeader
    }


}