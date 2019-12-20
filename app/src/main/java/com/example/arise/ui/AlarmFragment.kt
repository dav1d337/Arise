//package com.example.arise.ui
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.graphics.Color
//import android.os.Build
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProviders
//import com.example.arise.R
//import kotlinx.android.synthetic.main.activity_main.*
//import javax.inject.Inject
//
//class AlarmFragment : Fragment() {
////
////    @Inject
////    lateinit var viewModel: AlarmViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val binding: ActivityMainBinding = DataBindingUtil.inflate(
//            inflater, R.layout.activity_main, container, false
//        )
//
//        val viewModel = ViewModelProviders.of(this).get(AlarmViewModel::class.java)
//
//        binding.alarmViewModel = viewModel
//        binding.lifecycleOwner = this.viewLifecycleOwner
//
//        fab.setOnClickListener { view ->
//            val manager = fragmentManager
//            val fragment = CreateAlarmFragment()
//        //    fragment.show(manager, "CreateFragment")
//        }
//
//        createChannel(
//            getString(R.string.alarm_notification_channel_id),
//            "Hallo Alarm"
//        )
//
//        return binding.root
//    }
//
////    override fun onActivityCreated(savedInstanceState: Bundle?) {
////        super.onActivityCreated(savedInstanceState)
////
//////        AndroidInjection.inject(this)
////
////        viewModel.let {
////            val viewModelFactory = it.createFactory()
////            ViewModelProviders.of(this, viewModelFactory).get(it.javaClass)
////        }
////    }
//
//
//    fun createChannel(channelId: String, channelName: String) {
//        if (Build.VERSION.SDK_INT < 26) {
//            return
//        }
//        val channel = NotificationChannel(
//            channelId,
//            channelName,
//            NotificationManager.IMPORTANCE_HIGH
//        )
//        channel.enableLights(true)
//        channel.lightColor = Color.RED
//        channel.enableVibration(true)
//        channel.description = "Channel description"
//
//        val notificationManager = requireActivity().getSystemService(
//            NotificationManager::class.java
//        )
//        notificationManager.createNotificationChannel(channel)
//    }
//}