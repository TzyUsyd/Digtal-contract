import React, { useState, useEffect } from 'react';
import { Table, Tag, Space } from 'antd';

const axios = require('axios').default;



const data1 = [
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

function handleDelete(iou_id) {
    axios.delete('', id)
}

export default function IOUTable() {
    const [data, setData] = useState('');
    const tag = useState("IOU")

    useEffect(() => {
        axios.get('http://localhost:8080/iou/2')
        .then(function (response) {
            // handle success
            console.log(response);
            setData(response.data);
        })
        .catch(function (error) {
            // handle error
            console.log(error);
        })
        .then(function () {
            // always executed
        });

    }, [])
    
    const columns = [
        {
            title: 'ID',
            dataIndex: 'iouId',
            key: 'iouId',
            render: text => <a>{text}</a>,
        },
        {
            title: 'Type',
            key: {tag},
            dataIndex: {tag},
            render: type => {
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
            dataIndex: 'payerName',
            key: 'payerName',
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
                    <Button onClick={handleDelete}>Delete</Button>
                </Space>
            ),
        },
    ];
    return (
        <Table columns={columns} dataSource={data} style={{ margin: '5% auto', width: '100%' }} />
    )
}