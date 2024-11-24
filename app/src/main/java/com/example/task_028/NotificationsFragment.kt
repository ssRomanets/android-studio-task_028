package com.example.task_028

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationsFragment : Fragment() {
    var  notifications: MutableList<Notification> = mutableListOf()

    private lateinit var notificationET: EditText
    private lateinit var saveBTN: Button
    private lateinit var recyclerViewRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationET = view.findViewById(R.id.notificationET)
        saveBTN = view.findViewById(R.id.saveBTN)
        recyclerViewRV = view.findViewById(R.id.recyclerViewRV)

        saveBTN.setOnClickListener{
            createNotification();

            recyclerViewRV.layoutManager = LinearLayoutManager(context)
            recyclerViewRV.adapter = CustomAdapter(notifications)
            notificationET.text.clear()
        }
    }

    private fun createNotification() {
        val notificationId = notifications.size+1
        val notificationContent = notificationET.text.toString()
        val notificationData =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy, hh:mm:ss")).toString()

        val notification = Notification(notificationId, notificationContent, notificationData)
        notifications.add(notification)
    }
}