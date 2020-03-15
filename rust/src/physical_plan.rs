use crate::error::Result;

use arrow::record_batch::RecordBatch;
use tokio::net::TcpListener;
use tokio::prelude::*;
use std::future::Future;
use tokio::task::error::JoinError;
use std::sync::Arc;
use arrow::datatypes::Schema;

pub async fn execute() -> Result<RecordBatch> {
    println!("executing...");
    let schema = Schema::new(vec![]);
    Ok(RecordBatch::try_new(Arc::new(schema), vec![]).unwrap())
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::logical_plan::LogicalPlanBuilder;

    #[tokio::test]
    async fn test() -> Result<()> {
        let x = tokio::spawn(async move {
            execute()
        });
        let result: Result<Future, JoinError> = x.await;
        println!("{}", result.schema());
        Ok(())
    }
}