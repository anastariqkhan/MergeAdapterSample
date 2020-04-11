package com.sample.mergeadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.sample.mergeadapter.adapter.FooterAdapter
import com.sample.mergeadapter.adapter.MyDetailAdapter
import com.sample.mergeadapter.adapter.UserAdapter
import com.sample.mergeadapter.data.DataSource
import com.sample.mergeadapter.models.MyDetail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MergeAdapter
    lateinit var myDetailAdapter: MyDetailAdapter
    lateinit var userAdapter: UserAdapter
    lateinit var footerAdapter: FooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataInRecyclerView()

    }

    private fun setDataInRecyclerView() {
        val userDetail = MyDetail(1, "Danish Amjad", "Software Engineer Android Developer")
        recycler.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(DataSource.getUser())
        footerAdapter = FooterAdapter(DataSource.getFooter())
        myDetailAdapter = MyDetailAdapter(userDetail)
        adapter = MergeAdapter(myDetailAdapter,  userAdapter,footerAdapter)
        recycler.adapter = adapter
    }
}