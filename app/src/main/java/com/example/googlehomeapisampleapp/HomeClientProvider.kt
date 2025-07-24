
/* Copyright 2025 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.example.googlehomeapisampleapp

import android.content.Context
import com.google.home.Home
import com.google.home.HomeClient
import com.google.home.HomeConfig

// Singleton class to ensure Home.getClient is called only once
object HomeClientProvider {

    var homeClient: HomeClient? = null

    fun getClient(context: Context, homeConfig: HomeConfig): HomeClient {
        android.util.Log.i("SampleApp", "HomeClientProvider.getClient called with context=${context.javaClass.simpleName}")
        android.util.Log.i("SampleApp", "HomeConfig: coroutineContext=${homeConfig.coroutineContext}, factoryRegistry=${homeConfig.factoryRegistry}")
        
        if (homeClient == null) {
            android.util.Log.i("SampleApp", "Creating new HomeClient via Home.getClient()")
            homeClient = Home.getClient(context = context, homeConfig = homeConfig)
            android.util.Log.i("SampleApp", "HomeClient created: ${homeClient!!.javaClass.simpleName}@${homeClient!!.hashCode()}")
        } else {
            android.util.Log.i("SampleApp", "Reusing existing HomeClient: ${homeClient!!.javaClass.simpleName}@${homeClient!!.hashCode()}")
        }

        return homeClient!!
    }
}
