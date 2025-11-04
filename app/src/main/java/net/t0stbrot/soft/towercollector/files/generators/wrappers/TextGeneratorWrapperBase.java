/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.files.generators.wrappers;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;

import androidx.annotation.StringRes;

import net.t0stbrot.soft.towercollector.MyApplication;
import net.t0stbrot.soft.towercollector.files.generators.wrappers.interfaces.IProgressListener;
import net.t0stbrot.soft.towercollector.files.generators.wrappers.interfaces.IProgressiveTextGeneratorWrapper;

public abstract class TextGeneratorWrapperBase implements IProgressiveTextGeneratorWrapper {

    private final List<IProgressListener> progressListeners = new ArrayList<IProgressListener>();

    protected boolean cancel = false;

    public void addProgressListener(IProgressListener listener) {
        progressListeners.add(listener);
    }

    public void removeProgressListener(IProgressListener listener) {
        progressListeners.remove(listener);
    }

    protected void notifyProgressListeners(int value, int max) {
        for (IProgressListener listener : progressListeners) {
            listener.reportProgress(value, max);
        }
    }

    @Override
    public void cancel() {
        cancel = true;
    }

    public abstract Uri getFullPath();

    public abstract String getFileType();

    protected String getStringById(@StringRes int resId, Object... params) {
        return MyApplication.getApplication().getString(resId, params);
    }
}
