/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.providers;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import net.t0stbrot.soft.towercollector.model.ChangelogInfo;
import net.t0stbrot.soft.towercollector.model.ChangelogInfo.ChangelogEntry;
import net.t0stbrot.soft.towercollector.parsers.changelog.ChangelogFeedParseException;
import net.t0stbrot.soft.towercollector.parsers.changelog.ChangelogFeedParser;


import net.t0stbrot.soft.towercollector.utils.ResourceUtils;
import timber.log.Timber;

public class ChangelogProvider {


    private Context context;
    private int changelogId;
    private ChangelogFeedParser changelogParser;

    public ChangelogProvider(Context context, int changelogId) {
        this.context = context;
        this.changelogId = changelogId;
        this.changelogParser = new ChangelogFeedParser();
    }

    public ChangelogInfo getChangelog(int previousVersion) {
        try {
            String rawChangelog = ResourceUtils.getRawString(context, changelogId);
            ChangelogInfo changelog = changelogParser.parse(rawChangelog);
            List<ChangelogEntry> entriesToRemove = new ArrayList<ChangelogEntry>();
            for (ChangelogEntry entry : changelog.getEntries()) {
                if (entry.getVersionCode() <= previousVersion) {
                    entriesToRemove.add(entry);
                }
            }
            changelog.removeEntries(entriesToRemove);
            return changelog;
        } catch (ChangelogFeedParseException ex) {
            Timber.e(ex, "getChangelog(): Failed to parse changelog");
            return new ChangelogInfo();
        }
    }
}
