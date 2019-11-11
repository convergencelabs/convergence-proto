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

trait NormalMessage
trait RequestMessage
trait ResponseMessage

trait ProtocolMessage
trait ActivityMessage
trait AuthenticationMessage
trait ChatMessage
trait HistoricalMessage
trait IdentityMessage
trait ModelMessage
trait PermissionsMessage
trait PresenceMessage

trait PermissionRequest extends Request with Permissions  {
  def idType: PermissionType
}