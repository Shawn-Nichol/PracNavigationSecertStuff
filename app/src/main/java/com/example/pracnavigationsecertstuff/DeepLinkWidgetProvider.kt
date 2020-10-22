package com.example.pracnavigationsecertstuff

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder

/**
 * Implementation of App Widget functionality.
 */
class DeepLinkWidgetProvider : AppWidgetProvider() {
        override fun onUpdate(
            context: Context,
            appWidgetManager: AppWidgetManager?,
            appWidgetIds: IntArray?
        ) {

            val remoteViews = RemoteViews(
                context.packageName,
                R.layout.deep_link_widget_provider
            )

            val args = Bundle()

            val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.SuperSecret_dest)
                .createPendingIntent()

            remoteViews.setOnClickPendingIntent(R.id.deep_link_button, pendingIntent)

            appWidgetManager?.updateAppWidget(appWidgetIds, remoteViews)
        }
    }