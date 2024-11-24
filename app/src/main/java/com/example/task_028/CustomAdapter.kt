package com.example.task_028

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val notifications: MutableList<Notification>):
    RecyclerView.Adapter<CustomAdapter.NotificationViewHolder>(){

    class NotificationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val notificationIDTV: TextView = itemView.findViewById(R.id.notificationIDTV)
        val notificationContentTV: TextView = itemView.findViewById(R.id.notificationContentTV)
        val notificationDataTV: TextView = itemView.findViewById(R.id.notificationDataTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return NotificationViewHolder(itemView)
    }

    override fun getItemCount() = notifications.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]
        holder.notificationIDTV.text = notification.iD.toString()
        holder.notificationContentTV.text = notification.notifyContent.toString()
        holder.notificationDataTV.text = notification.notifyData.toString()
    }
}