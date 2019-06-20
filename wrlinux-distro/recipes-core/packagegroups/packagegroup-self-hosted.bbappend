#
# Copyright (C) 2014 Wind River Systems, Inc.
#

# The graphics packages in packagegroup-self-hosted-graphics
# are for Build Appliance usage in oe-core which are not
# needed in our self-hosted feature.
# So drop the graphics packagegroup.
REQUIRED_DISTRO_FEATURES_remove_osv-wrlinux = "x11 opengl"
PACKAGES_remove_osv-wrlinux = "packagegroup-self-hosted-graphics"
RDEPENDS_packagegroup-self-hosted_remove_osv-wrlinux = "packagegroup-self-hosted-graphics"
RDEPENDS_packagegroup-self-hosted-extended_remove_osv-wrlinux = "settings-daemon"
