/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.tasks;

import android.app.Activity;
import android.widget.Toast;

import net.t0stbrot.soft.towercollector.MyApplication;
import net.t0stbrot.soft.towercollector.dao.MeasurementsDatabase;
import net.t0stbrot.soft.towercollector.model.AnalyticsStatistics;
import timber.log.Timber;

public class DatabaseUpgradeTask {

    private final Activity activity;
    private final int oldDbVersion;

    public DatabaseUpgradeTask(Activity activity, int oldDbVersion) {
        this.activity = activity;
        this.oldDbVersion = oldDbVersion;
    }

    public void upgrade() {
        Timber.d("upgrade(): Loading data and running migration if necessary");
        try {
            // invalidate database (protects against crash when database swapped while application paused - generally for testing)
            MeasurementsDatabase.invalidateInstance();
            long startTime = System.currentTimeMillis();
            // one of below will trigger data migration if necessary (long operation)
            MeasurementsDatabase.getInstance(MyApplication.getApplication()).forceDatabaseUpgrade();
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
        } catch (RuntimeException ex) {
            Timber.e(ex, "upgrade(): Database migration from version %s crashed", oldDbVersion);
            Toast.makeText(activity, "Database upgrade failed. Please clear app data or reinstall.", Toast.LENGTH_LONG).show();
            MyApplication.handleSilentException(ex);
            throw ex;
        }
    }
}
