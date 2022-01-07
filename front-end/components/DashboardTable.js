import React from 'react';
import { Table, Tag, Space } from 'antd';

const columns = [
    {
        title: 'ID',
        dataIndex: 'key',
        key: 'key',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Type',
        key: 'type',
        dataIndex: 'type',
        render:  type => {
                    let color = 'geekblue'
                    return (
                        <Tag color={color}>
                            {type}
                        </Tag>
                    );
                }
    },
    {
        title: 'Party A',
        dataIndex: 'partyA',
        key: 'partyA',
    },
    {
        title: 'Party B',
        dataIndex: 'partyB',
        key: 'partyB',
    },
    {
        title: 'Date',
        dataIndex: 'date',
        key: 'date',
    },
    {
        title: 'Action',
        key: 'action',
        render: (text, record) => (
            <Space size="middle">
                {/* <a>Invite</a> */}
                <a>Delete</a>
            </Space>
        ),
    },
];

const data = [
    {
        key: '1',
        partyA: 'John Brown',
        partyB: 'Hunter Xu',
        date: '2021-10-25',
        tags: ['normal'],
        type: 'IOU'
    },
    {
        key: '2',
        partyA: 'Jim Green',
        partyB: 'Hunter Xu',
        date: '2021-10-25',
        tags: ['normal'],
        type: 'IOU'
    },
    {
        key: '3',
        partyA: 'Joe Black',
        partyB: 'Hunter Xu',
        date: '2021-10-25',
        tags: ['normal'],
        type: 'IOU'
    },
];

export default function DashboardTable() {
    return (
        <Table columns={columns} dataSource={data} style={{ margin: '5% auto', width: '100%' }} />
    )
}