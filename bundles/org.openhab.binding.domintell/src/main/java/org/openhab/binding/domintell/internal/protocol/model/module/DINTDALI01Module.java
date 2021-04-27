/**
 * Copyright (c) 2010-2021 Contributors to the openHAB project
 * <p>
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 * <p>
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * <p>
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.domintell.internal.protocol.model.module;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.binding.domintell.internal.protocol.DomintellConnection;
import org.openhab.binding.domintell.internal.protocol.message.StatusMessage;
import org.openhab.binding.domintell.internal.protocol.model.Item;
import org.openhab.binding.domintell.internal.protocol.model.ItemKey;
import org.openhab.binding.domintell.internal.protocol.model.SerialNumber;
import org.openhab.binding.domintell.internal.protocol.model.type.DataType;
import org.openhab.binding.domintell.internal.protocol.model.type.ModuleType;

/**
 * The {@link DDIM01Module} class is model class of DDIM01 module
 *
 * @author Gabor Bicskei - Initial contribution
 */
@NonNullByDefault
public class DINTDALI01Module extends DimmerModule {
    public DINTDALI01Module(DomintellConnection connection, SerialNumber serialNumber) {
        super(connection, ModuleType.DAL, serialNumber, 64);
    }

    protected void updateItems(StatusMessage message) {
        @Nullable
        String dataStr = message.getData();
        @Nullable
        DataType dataType = message.getDataType();
        @Nullable
        Integer ioNumber = message.getIoNumber();
        if (dataStr != null && ioNumber != null && dataType == DataType.D) {
            @Nullable
            Item<Integer> item = (Item<Integer>) getItems().get(new ItemKey(getModuleKey(), ioNumber));
            if (item != null) {
                Integer value = Integer.parseInt(dataStr, 16);
                item.setValue(value);
            }
        }
    }
}
