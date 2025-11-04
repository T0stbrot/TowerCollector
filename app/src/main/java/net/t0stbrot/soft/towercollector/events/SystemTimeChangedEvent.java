/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.events;

import net.t0stbrot.soft.towercollector.enums.Validity;

public class SystemTimeChangedEvent {
    private Validity valid;

    public SystemTimeChangedEvent(Validity valid) {
        this.valid = valid;
    }

    public Validity isValid() {
        return this.valid;
    }
}
