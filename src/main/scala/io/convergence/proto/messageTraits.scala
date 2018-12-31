package io.convergence.proto

import io.convergence.proto.permissions.PermissionType

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