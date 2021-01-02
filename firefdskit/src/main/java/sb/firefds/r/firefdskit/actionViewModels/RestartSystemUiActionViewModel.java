/*
 * Copyright (C) 2021 Shauli Bracha for Firefds Kit Project (Firefds@xda)
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
package sb.firefds.r.firefdskit.actionViewModels;

import android.os.Handler;
import android.os.Process;

import sb.firefds.r.firefdskit.R;

import static sb.firefds.r.firefdskit.XSysUIGlobalActions.getResources;
import static sb.firefds.r.firefdskit.utils.Constants.RESTART_UI_ACTION;

public class RestartSystemUiActionViewModel extends FirefdsKitActionViewModel {

    RestartSystemUiActionViewModel() {

        super();
        getActionInfo().setName(RESTART_UI_ACTION);
        getActionInfo().setLabel(getResources().getString(R.string.restartUI));
        getActionInfo().setDescription(getResources().getString(R.string.restartUI));
        setDrawableIcon(getResources().getDrawable(R.drawable.tw_ic_do_restart_ui_stock, null));
    }

    @Override
    public void onPress() {
        if (!getGlobalActions().isActionConfirming()) {
            getGlobalActions().confirmAction(this);
        } else {
            getGlobalActions().dismissDialog(false);
            new Handler().postDelayed(this::restartSystemUI, 1000);
        }
    }

    @Override
    public void onPressSecureConfirm() {
        restartSystemUI();
    }

    private void restartSystemUI() {
        Process.killProcess(Process.myPid());
    }
}
