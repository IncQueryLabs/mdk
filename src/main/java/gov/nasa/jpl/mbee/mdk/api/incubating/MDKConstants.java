package gov.nasa.jpl.mbee.mdk.api.incubating;

import com.nomagic.uml2.ext.magicdraw.metadata.UMLPackage;

/**
 * Created by igomes on 9/26/16.
 */
public class MDKConstants {
    public static final String
            HIDDEN_ID_PREFIX = "_hidden_",
            DERIVED_KEY_PREFIX = "_",
            SYNC_SYSML_ID_SUFFIX = "_sync",
            APPLIED_STEREOTYPE_INSTANCE_ID_SUFFIX = "_asi",
            TIME_EXPRESSION_ID_SUFFIX = "_time_expression",
            ID_KEY_SUFFIX = "Id",
            IDS_KEY_SUFFIX = ID_KEY_SUFFIX + "s",
            SLOT_ID_SEPARATOR = "-slot-",
            SLOT_VALUE_ID_SEPARATOR = SLOT_ID_SEPARATOR.substring(0, SLOT_ID_SEPARATOR.length() - 1) + "value-",
            HOLDING_BIN_PACKAGE_ID_REGEX = "^(holding_bin|(Y|M|D|H){2}_[0-9]+)_.+$",
            TYPE_KEY = "type",
            NAME_KEY = "name",
            SYSML_ID_KEY = "sysml" + ID_KEY_SUFFIX,
            OWNER_ID_KEY = UMLPackage.Literals.ELEMENT__OWNER.getName() + ID_KEY_SUFFIX,
            INSTANCE_ID_KEY = UMLPackage.Literals.INSTANCE_VALUE__INSTANCE.getName() + ID_KEY_SUFFIX,
            CONTENTS_KEY = DERIVED_KEY_PREFIX + "contents",
            DIAGRAM_TYPE_KEY = DERIVED_KEY_PREFIX + "diagramType";
}
