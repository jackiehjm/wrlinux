#
# Copyright (C) 2012 Wind River Systems, Inc.
#
DESCRIPTION = "An image which approximates WRLinux 4.3 glibc-cgl."

LICENSE = "MIT"

# we extend glibc-std
require recipes-base/images/wrlinux-image-glibc-std.bb


IMAGE_FEATURES += "ssh-server-openssh"

#  Networking common packages
IMAGE_INSTALL += "packagegroup-wr-core-networking"

#  Core CGL Packages, without these you don't have a CGL system
IMAGE_INSTALL += "packagegroup-wr-core-cgl"

#  All CGL configurations include SELinux
IMAGE_INSTALL += "packagegroup-core-selinux"

#  Security common packages
IMAGE_INSTALL += "packagegroup-wr-core-security"
