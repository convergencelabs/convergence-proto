/*
 * Copyright (C) Convergence Labs, Inc
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package com.convergencelabs.convergence.proto

import com.convergencelabs.convergence.proto.core.PermissionTarget

trait ServerMessage
trait ClientMessage

trait NormalMessage
trait RequestMessage
trait ResponseMessage

trait ProtocolMessage
trait ActivityMessage
trait AuthenticationMessage
trait ChatMessage
trait IdentityMessage
trait ModelMessage
trait HistoricalModelMessage
trait PermissionsMessage
trait PresenceMessage

trait PermissionRequest extends RequestMessage with PermissionsMessage  {
  def target: Option[PermissionTarget]
}