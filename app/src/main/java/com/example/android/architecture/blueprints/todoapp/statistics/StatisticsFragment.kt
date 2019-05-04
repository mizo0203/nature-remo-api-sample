/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.architecture.blueprints.todoapp.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mizo0203.natureremoapisample.R

/**
 * Main UI for the statistics screen.
 */
class StatisticsFragment : Fragment(), StatisticsContract.View {

    private lateinit var statisticsTV: TextView

    override lateinit var presenter: StatisticsContract.Presenter

    override val isActive: Boolean
        get() = isAdded

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.statistics_frag, container, false)
        statisticsTV = root.findViewById(R.id.statistics)
        return root
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun setProgressIndicator(active: Boolean) {
        if (active) {
            statisticsTV.text = getString(R.string.loading)
        } else {
            statisticsTV.text = ""
        }
    }

    override fun showStatistics(numberOfIncompleteTasks: Int, numberOfCompletedTasks: Int) {
        if (numberOfCompletedTasks == 0 && numberOfIncompleteTasks == 0) {
            statisticsTV.text = resources.getString(R.string.statistics_no_tasks)
        } else {
            val displayString = "${resources.getString(R.string.statistics_active_tasks)} " +
                    "$numberOfIncompleteTasks\n" +
                    "${resources.getString(R.string.statistics_completed_tasks)} " +
                    "$numberOfCompletedTasks"
            statisticsTV.text = displayString
        }
    }

    override fun showLoadingStatisticsError() {
        statisticsTV.text = resources.getString(R.string.statistics_error)
    }

    companion object {

        fun newInstance(): StatisticsFragment {
            return StatisticsFragment()
        }
    }
}
