/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.preferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import info.zamojski.soft.towercollector.R;

public class HeaderPreferenceFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_headers, rootKey);
    }
}
