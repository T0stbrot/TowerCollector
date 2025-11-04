/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.providers.preferences.migration;

import android.content.Context;

import net.t0stbrot.soft.towercollector.providers.preferences.BooleanPreferenceProvider;
import net.t0stbrot.soft.towercollector.providers.preferences.StringPreferenceProvider;

public class UpgradeScriptBase {

    protected BooleanPreferenceProvider getBooleanPreferenceProvider(Context context) {
        return new BooleanPreferenceProvider(context);
    }

    protected StringPreferenceProvider getStringPreferenceProvider(Context context) {
        return new StringPreferenceProvider(context);
    }
}
