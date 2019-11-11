/*
 * Copyright (C) Convergence Labs, Inc
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.convergencelabs.convergence.proto

import com.convergencelabs.convergence.proto.core.PermissionType

trait ServerMessage
trait ClientMessage

trait Normal
trait Request
trait Response

trait Protocol
trait Activity
trait Authentication
trait Chat
trait Historical
trait Identity
trait Model
trait Permissions
trait Presence

trait PermissionRequest extends Request with Permissions  {
  def idType: PermissionType
}