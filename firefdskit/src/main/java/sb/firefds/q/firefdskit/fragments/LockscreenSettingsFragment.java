/*
 * Copyright (C) 2020 Shauli Bracha for Firefds Kit Project (Firefds@xda)
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
package sb.firefds.q.firefdskit.fragments;

import android.os.Bundle;

import sb.firefds.q.firefdskit.R;

public class LockscreenSettingsFragment extends FirefdsPreferenceFragment {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        getPreferenceManager().setStorageDeviceProtected();
        setPreferencesFromResource(R.xml.lockscreen_settings, rootKey);
    }

    @Override
    public String getFragmentName() {
        return "lockscreenKey";
    }

    @Override
    public boolean isSubFragment() {
        return false;
    }
}
