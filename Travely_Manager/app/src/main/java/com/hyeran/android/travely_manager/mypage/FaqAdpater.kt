package com.hyeran.android.travely_user.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import com.hyeran.android.travely_manager.R
import kotlinx.android.synthetic.main.item_faq_group.view.*

class FaqAdapter(var context: Context, var faqexpandedView: ExpandableListView, var header: MutableList<String>, var body: MutableList<MutableList<String>>) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any {
        return header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.item_faq_group, null)
        }
        val title = convertView!!.findViewById<TextView>(R.id.tv_grouptitle_faq)
        title.text = getGroup(groupPosition).toString()
        title?.setOnClickListener {
            if (faqexpandedView.isGroupExpanded(groupPosition)) {
                faqexpandedView.collapseGroup(groupPosition)


            } else {
                faqexpandedView.expandGroup(groupPosition)

            }
        }
        convertView.notice_arrow.isPressed = isExpanded

        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()

    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView



        if (convertView == null) {

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.item_faq_child, null)
        }
        val title = convertView?.findViewById<TextView>(R.id.tv_childtitle_faq)
        title?.text = getChild(groupPosition, childPosition).toString()
        title?.setOnClickListener {

        }

        return convertView!!
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }

}