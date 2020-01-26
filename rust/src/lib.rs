//! Ballista is a proof-of-concept distributed compute platform based on Kubernetes and the Rust implementation of Apache Arrow.

// include the generated protobuf source as a submodule
// https://github.com/tower-rs/tower-grpc/issues/194
#[allow(clippy::all)]
pub mod proto {
    include!(concat!(env!("OUT_DIR"), "/ballista.rs"));
}

pub mod client;
pub mod cluster;
pub mod error;
pub mod execution;
pub mod logical_plan;

pub use arrow;
pub use datafusion;
