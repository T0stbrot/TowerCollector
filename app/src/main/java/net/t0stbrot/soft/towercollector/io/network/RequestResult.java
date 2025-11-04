/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package net.t0stbrot.soft.towercollector.io.network;

public enum RequestResult {
    Success, Failure, ConfigurationError, InvalidApiKey, ConnectionError, ServerError, LimitExceeded
}
