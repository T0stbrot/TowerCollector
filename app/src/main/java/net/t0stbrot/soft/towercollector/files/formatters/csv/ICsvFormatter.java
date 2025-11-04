/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.files.formatters.csv;

import net.t0stbrot.soft.towercollector.model.Measurement;

public interface ICsvFormatter {

    String formatHeader();

    String formatEntry(Measurement m);

}
