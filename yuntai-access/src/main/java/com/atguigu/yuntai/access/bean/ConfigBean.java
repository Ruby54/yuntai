package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@NoArgsConstructor
public class ConfigBean {
    private String bigint_unsigned_handling_mode;
    private String binary_handling_mode;
    private String binlog_buffer_size;
    private String collection_exclude_list;
    private String collection_include_list;
    private String column_exclude_list;
    private String column_include_list;
    private String column_propagate_source_type;
    private String connect_backoff_initial_delay_ms;
    private String connect_backoff_max_delay_ms;
    private String connect_keep_alive;
    private String connect_max_attempts;
    private String connect_timeout_ms;
    private String connector_class;
    private String cursor_max_await_time_ms;
    private String database_connection_adapter;
    private String database_dbname;
    private String database_exclude_list;
    private String database_history_kafka_bootstrap_servers;
    private String database_history_kafka_recovery_attempts;
    private String database_history_kafka_recovery_poll_interval_ms;
    private String database_history_kafka_topic;
    private String database_history_skip_unparseable_ddl;
    private String database_history_store_only_captured_tables_ddl;
    private String database_history_store_only_monitored_tables_ddl;
    private String database_hostname;
    private String database_include_list;
    private String database_initial_statements;
    private String database_names;
    private String database_password;
    private String database_pdb_name;
    private String database_port;
    private String database_server_id;
    private String database_server_name;
    private String database_ssl_mode;
    private String database_sslcert;
    private String database_sslkey;
    private String database_sslmode;
    private String database_sslpassword;
    private String database_sslrootcert;
    private String database_tcpKeepAlive;
    private String database_url;
    private String database_user;
    private String datatype_propagate_source_type;
    private String decimal_handling_mode;
    private String enable_time_adjuster;
    private String event_deserialization_failure_handling_mode;
    private String event_processing_failure_handling_mode;
    private String field_exclude_list;
    private String field_renames;
    private String gtid_new_channel_position;
    private String gtid_source_excludes;
    private String gtid_source_includes;
    private String heartbeat_action_query;
    private String heartbeat_interval_ms;
    private String heartbeat_topics_prefix;
    private String hstore_handling_mode;
    private String include_query;
    private String include_schema_changes;
    private String include_unknown_datatypes;
    private String inconsistent_schema_handling_mode;
    private String incremental_snapshot_chunk_size;
    private String interval_handling_mode;
    private String lob_enabled;
    private String log_mining_archive_destination_name;
    private String log_mining_archive_log_hours;
    private String log_mining_archive_log_only_mode;
    private String log_mining_archive_log_only_scn_poll_interval_ms;
    private String log_mining_batch_size_default;
    private String log_mining_batch_size_max;
    private String log_mining_batch_size_min;
    private String log_mining_buffer_drop_on_stop;
    private String log_mining_buffer_location;
    private String log_mining_buffer_type;
    private String log_mining_scn_gap_detection_gap_size_min;
    private String log_mining_scn_gap_detection_time_interval_max_ms;
    private String log_mining_sleep_time_default_ms;
    private String log_mining_sleep_time_increment_ms;
    private String log_mining_sleep_time_max_ms;
    private String log_mining_sleep_time_min_ms;
    private String log_mining_strategy;
    private String log_mining_transaction_retention_hours;
    private String log_mining_username_exclude_list;
    private String log_mining_view_fetch_size;
    private String max_batch_size;
    private String max_iteration_transactions;
    private String max_queue_size;
    private String max_queue_size_in_bytes;
    private String message_key_columns;
    private String min_row_count_to_stream_results;
    private String mongodb_authsource;
    private String mongodb_connect_timeout_ms;
    private String mongodb_hosts;
    private String mongodb_members_auto_discover;
    private String mongodb_name;
    private String mongodb_password;
    private String mongodb_poll_interval_ms;
    private String mongodb_server_selection_timeout_ms;
    private String mongodb_socket_timeout_ms;
    private String mongodb_ssl_enabled;
    private String mongodb_ssl_invalid_hostname_allowed;
    private String mongodb_user;
    private String name;
    private String plugin_name;
    private String poll_interval_ms;
    private String provide_transaction_metadata;
    private String publication_autocreate_mode;
    private String publication_name;
    private String query_fetch_size;
    private String rac_nodes;
    private String read_only;
    private String retriable_restart_connector_wait_ms;
    private String sanitize_field_names;
    private String schema_exclude_list;
    private String schema_include_list;
    private String schema_refresh_mode;
    private String signal_data_collection;
    private String signal_kafka_bootstrap_servers;
    private String signal_kafka_poll_timeout_ms;
    private String signal_kafka_topic;
    private String skipped_operations;
    private String slot_drop_on_stop;
    private String slot_max_retries;
    private String slot_name;
    private String slot_retry_delay_ms;
    private String slot_stream_params;
    private String snapshot_collection_filter_overrides;
    private String snapshot_custom_class;
    private String snapshot_delay_ms;
    private String snapshot_fetch_size;
    private String snapshot_include_collection_list;
    private String snapshot_isolation_mode;
    private String snapshot_lock_timeout_ms;
    private String snapshot_locking_mode;
    private String snapshot_max_threads;
    private String snapshot_mode;
    private String snapshot_select_statement_overrides;
    private String source_struct_version;
    private String status_update_interval_ms;
    private String table_exclude_list;
    private String table_ignore_builtin;
    private String table_include_list;
    private String tasks_max;
    private String time_precision_mode;
    private String toasted_value_placeholder;
    private String tombstones_on_delete;
    private String truncate_handling_mode;
    private String unavailable_value_placeholder;
    private String vitess_database_password;
    private String vitess_database_user;
    private String vitess_keyspace;
    private String vitess_shard;
    private String vitess_tablet_type;
    private String vitess_vtctld_host;
    private String vitess_vtctld_password;
    private String vitess_vtctld_port;
    private String vitess_vtctld_user;

    private final Class<? extends ConfigBean> thisClass = this.getClass();

    public void readConfig(JSONObject config) {
        for (String key : config.keySet()) {
            try {
                Field field = thisClass.getDeclaredField(key.replace('.', '_'));
                field.setAccessible(true);
                field.set(this, config.get(key));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject dump() {

        JSONObject jsonObject = new JSONObject();

        Field[] fields = thisClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                //遍历所有属性
                if ("thisClass".equals(field.getName())) {
                    continue;
                }
                field.setAccessible(true);

                //获取属性值
                Object temp = field.get(this);

                //向JsonObject中赋值
                if (temp != null) {
                    jsonObject.put(field.getName().replace('_', '.'), temp.toString());
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return jsonObject;

    }

}
