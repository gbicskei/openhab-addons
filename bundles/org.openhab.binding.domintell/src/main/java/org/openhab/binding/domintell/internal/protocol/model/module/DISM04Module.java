/**
 * Copyright (c) 2010-2021 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.domintell.internal.protocol.model.module;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.domintell.internal.protocol.DomintellConnection;
import org.openhab.binding.domintell.internal.protocol.model.SerialNumber;
import org.openhab.binding.domintell.internal.protocol.model.type.ModuleType;

/**
 * The {@link DISM04Module} class is model class for DISM04 Domintell module
 *
 * @author Gabor Bicskei - Initial contribution
 */
@NonNullByDefault
public class DISM04Module extends ContactModule {
    public DISM04Module(DomintellConnection connection, SerialNumber serialNumber) {
        super(connection, ModuleType.IS4, serialNumber, 4);
    }
}
