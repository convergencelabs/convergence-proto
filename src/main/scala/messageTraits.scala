package io.convergence.proto

import io.convergence.proto.permissions.PermissionType

trait Incoming
trait Outgoing
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

trait PermissionRequest extends Incoming with Request with Permissions  {
  def idType: PermissionType
}