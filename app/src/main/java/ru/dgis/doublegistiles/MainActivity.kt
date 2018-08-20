package ru.dgis.doublegistiles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.dgis.doublegistiles.model.FirmDto
import ru.dgis.doublegistiles.model.FirmListDto

class MainActivity : AppCompatActivity() {

    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inflater = LayoutInflater.from(this)

        val recyclerView = findViewById<RecyclerView>(R.id.am_rv)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        rvAdapter = RvAdapter(inflater, FirmListDto(getFirms()), this)
        recyclerView.adapter = rvAdapter

        val divider = DividerItemDecoration(this, layoutManager.orientation)
        recyclerView.addItemDecoration(divider)
    }

    private fun getFirms() : List<FirmDto> {
        return listOf(FirmDto(1, "Firm1", "1", "Rubric 1"),
                FirmDto(2, "Firm2", "1", "Rubric 2"),
                FirmDto(3, "Firm3", "2", "Rubric 3"))
    }

    class RvAdapter(private val inflater: LayoutInflater,
                    private val dto: FirmListDto,
                    private val mainActivity: MainActivity) : RecyclerView.Adapter<FirmSimpleView>() {

        override fun getItemCount(): Int {
            return if (dto.items == null) {
                0
            } else dto.items!!.size
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FirmSimpleView {

            return FirmSimpleView.createView(viewGroup, inflater, dto.items[i])
        }

        override fun onBindViewHolder(cardView: FirmSimpleView, i: Int) {
            cardView.initView(dto.items[i])
            /*cardView.itemView.setOnClickListener({ v ->
                run {
                    val fm = mainActivity.supportFragmentManager
                    val dialog = FirmEditableViewImpl.createView(v.getTag() as FirmDto, mainActivity)
                    dialog.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppTheme)
                    dialog.show(fm, null)
                }
            })*/
        }

        fun setItems(firms: List<FirmDto>) {
            dto.items = firms
            notifyDataSetChanged()
        }
    }
}
