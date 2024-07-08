package com.raihandepani.projectuas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raihandepani.projectuas.R

class ProfileFragment : Fragment() {

    lateinit var image: ImageView
    lateinit var title: TextView
    lateinit var subtitle: TextView
    lateinit var list: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        title = root.findViewById(R.id.title)
        subtitle = root.findViewById(R.id.subtitle)
        image = root.findViewById(R.id.image)
        list = root.findViewById(R.id.list)

        title.text = "Raihan De Pani"
        subtitle.text = "2210031802014"
        list.adapter = linkAdapter

        return root
    }


    private val linkAdapter by lazy {
        val items = listOf<LinkModel>(
            LinkModel("WhatsApp", R.drawable.wa, "https://api.whatsapp.com/send/?phone=%2B6283161826690&text&type=phone_number&app_absent=0"),

            )

        LinkAdapter(items, object : LinkAdapter.AdapterListener {
            override fun onClick(linktree: LinkModel) {1
                Log.e("onClick", linktree.url)
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}